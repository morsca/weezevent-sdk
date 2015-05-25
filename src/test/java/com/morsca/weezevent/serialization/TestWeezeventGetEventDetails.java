package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.response.WeezeventEventDetailsResponse;

public class TestWeezeventGetEventDetails {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetEventDetails() throws Exception {
		WeezeventEventDetailsResponse eventDetailsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getEventDetails.json"), WeezeventEventDetailsResponse.class);
		
		Assert.assertNotNull(eventDetailsResponse);
		Assert.assertEquals(dateFormat.parse("27/05/2013 18:02:16"), eventDetailsResponse.getLastUpdate());
	}
}
