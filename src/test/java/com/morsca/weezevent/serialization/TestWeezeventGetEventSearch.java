package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventEventDetails;
import com.morsca.weezevent.response.WeezeventEventSearchResponse;

public class TestWeezeventGetEventSearch {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.ROOT);
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.configure(Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetEventSearch() throws Exception {
		WeezeventEventSearchResponse eventSearchResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getEventSearch.json"), WeezeventEventSearchResponse.class);
		
		Assert.assertNotNull(eventSearchResponse);
		Assert.assertEquals(dateFormat.parse("27/05/2013 17:56:50"), eventSearchResponse.getLastUpdate());
		Assert.assertEquals(1, eventSearchResponse.getCount());
		Assert.assertNotNull(eventSearchResponse.getEvents());
		Assert.assertFalse(eventSearchResponse.getEvents().isEmpty());
		Iterator<WeezeventEventDetails> eventsIterator = eventSearchResponse.getEvents().iterator();
		
		WeezeventEventDetails eventDetails = eventsIterator.next();
		Assert.assertEquals(19988, eventDetails.getId());
		Assert.assertEquals("Inscription NODE 2012/2013", eventDetails.getTitle());
		Assert.assertEquals("http://bxno.de", eventDetails.getSiteUrl());
		Assert.assertEquals("\\u003Cp\\u003E\\r\\n\\t\\u003Cstrong\\u003ECette inscription donne acc\\u00e8s au NODE jusqu\\u0026#39au 31 d\\u00e9cembre 2013.\\u003C/strong\\u003E\\u003C/p\\u003E\\r\\n\\u003Cp\\u003E\\r\\n\\t\\u003Cem\\u003E(les appels \\u00e0 cotisation pour 2014 seront lanc\\u00e9 le 1er juillet 2013.)\\u003C/em\\u003E\\u003C/p\\u003E\\r\\n", eventDetails.getDescription());
		Assert.assertEquals("", eventDetails.getImage());
		Assert.assertEquals(38, eventDetails.getCategory().getId());
		Assert.assertEquals("Dons en ligne", eventDetails.getCategory().getName());
		Assert.assertEquals(dateFormat.parse("20/07/2012 00:00:00"), eventDetails.getPeriod().getStart());
		Assert.assertEquals(dateFormat.parse("30/06/2013 23:55:59"), eventDetails.getPeriod().getEnd());
		Assert.assertEquals(0, eventDetails.getPrice().getMin(), 0);
		Assert.assertEquals(1000, eventDetails.getPrice().getMax(), 0);
		Assert.assertEquals("", eventDetails.getVenue().getName());
		Assert.assertEquals("", eventDetails.getVenue().getAddress());
		Assert.assertEquals("", eventDetails.getVenue().getZipCode());
		Assert.assertEquals("", eventDetails.getVenue().getCity());
		Assert.assertEquals("", eventDetails.getVenue().getState());
		Assert.assertNull(eventDetails.getVenue().getCountry().getCode());
		Assert.assertNull(eventDetails.getVenue().getCountry().getName());
		Assert.assertEquals(0, eventDetails.getVenue().getCoordinates().getLongitude(), 0);
		Assert.assertEquals(0, eventDetails.getVenue().getCoordinates().getLatitude(), 0);
		Assert.assertNotNull(eventDetails.getExtras());
		Assert.assertNotNull(eventDetails.getExtras().get("minisite_url"));
		Assert.assertEquals("http://weezevent.dev/inscription-node-2012-2013", eventDetails.getExtras().get("minisite_url"));
	}
}
