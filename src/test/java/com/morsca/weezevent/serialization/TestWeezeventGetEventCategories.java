package com.morsca.weezevent.serialization;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventEventCategory;
import com.morsca.weezevent.response.WeezeventEventCategoriesResponse;

public class TestWeezeventGetEventCategories {

	private final ObjectMapper mapper = new ObjectMapper();
	
	private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		mapper.setDateFormat(new SimpleDateFormat("yyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void testWeezeventGetEventCategories() throws Exception {
		WeezeventEventCategoriesResponse eventCategoriesResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getEventCategories.json"), WeezeventEventCategoriesResponse.class);
		
		Assert.assertNotNull(eventCategoriesResponse);
		Assert.assertEquals(dateFormat.parse("24/05/2013 16:02:27"), eventCategoriesResponse.getLastUpdate());
		Assert.assertNotNull(eventCategoriesResponse.getEventCategories());
		Assert.assertFalse(eventCategoriesResponse.getEventCategories().isEmpty());
		
		Iterator<WeezeventEventCategory> eventCategoriesIterator = eventCategoriesResponse.getEventCategories().iterator();
		
		WeezeventEventCategory eventCategory = eventCategoriesIterator.next();
		Assert.assertEquals(14, eventCategory.getId());
		Assert.assertEquals("Soirée clubbing", eventCategory.getName());
		Assert.assertEquals("Soirée clubbing", eventCategory.getNameOther());
		
	}
}
