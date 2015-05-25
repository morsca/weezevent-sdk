package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventEvent;
import com.morsca.weezevent.response.WeezeventEventsResponse;

public class TestWeezeventGetEvent {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetEvent() throws Exception {
		WeezeventEventsResponse eventsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getEvent.json"), WeezeventEventsResponse.class);
		
		Assert.assertNotNull(eventsResponse.getEvents());
		Assert.assertFalse(eventsResponse.getEvents().isEmpty());
		
		Iterator<WeezeventEvent> eventsIterator = eventsResponse.getEvents().iterator();
		WeezeventEvent event = eventsIterator.next();
		
		Assert.assertEquals(13824, event.getId());
		Assert.assertEquals("Event 1", event.getName());
		Assert.assertEquals(dateFormat.parse("10/10/2011"), event.getDate().getStart());
		Assert.assertNull(event.getDate().getEnd());
		Assert.assertEquals(0, event.getParticipants());
		Assert.assertEquals(0, event.getMultipleDates());
		
		Assert.assertTrue(eventsIterator.hasNext());
		event = eventsIterator.next();
		
		Assert.assertEquals(11435, event.getId());
		Assert.assertEquals("Event 2", event.getName());
		Assert.assertEquals(dateFormat.parse("27/11/2011"), event.getDate().getStart());
		Assert.assertNull(event.getDate().getEnd());
		Assert.assertEquals(24, event.getParticipants());
		Assert.assertEquals(1, event.getMultipleDates());
	}
}
