package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventDate;
import com.morsca.weezevent.response.WeezeventDatesResponse;

public class TestWeezeventGetDates {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetDates() throws Exception {
		WeezeventDatesResponse datesResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getDates.json"), WeezeventDatesResponse.class);
		
		Assert.assertNotNull(datesResponse.getDates());
		Assert.assertFalse(datesResponse.getDates().isEmpty());
		
		Iterator<WeezeventDate> datesIterator = datesResponse.getDates().iterator();
		
		WeezeventDate date = datesIterator.next();
		Assert.assertEquals(138, date.getId());
		Assert.assertEquals(11435, date.getIdEvent());
		Assert.assertEquals(dateFormat.parse("10/01/2013 14:20"), date.getDate());
		Assert.assertArrayEquals(new Long[]{ 75632L, 75633L, 75634L}, date.getTickets().toArray());
		
		Assert.assertTrue(datesIterator.hasNext());
		
		date = datesIterator.next();
		Assert.assertEquals(139, date.getId());
		Assert.assertEquals(11435, date.getIdEvent());
		Assert.assertEquals(dateFormat.parse("10/01/2013 16:20"), date.getDate());
		Assert.assertArrayEquals(new Long[]{ 75633L, 75634L}, date.getTickets().toArray());
		
		date = datesIterator.next();
		Assert.assertEquals(116, date.getId());
		Assert.assertEquals(10473, date.getIdEvent());
		Assert.assertEquals(dateFormat.parse("25/02/2013 11:55"), date.getDate());
		Assert.assertArrayEquals(new Long[]{ 75632L, 75633L}, date.getTickets().toArray());
	}
}
