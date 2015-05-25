package com.morsca.weezevent.serialization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.morsca.weezevent.domain.WeezeventScanSettings;
import com.morsca.weezevent.response.WeezeventScanSettingsResponse;

public class TestWeezeventGetScanSettings {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Before
	public void before() {
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
	}
	
	@Test
	public void testWeezeventGetScanSettings() throws Exception {
		WeezeventScanSettingsResponse scanSettingsResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getScanSettings.json"), WeezeventScanSettingsResponse.class);
		
		Assert.assertNotNull(scanSettingsResponse.getSettings());
		WeezeventScanSettings settings = scanSettingsResponse.getSettings();

		Assert.assertEquals("test", settings.getTest());
		Assert.assertEquals(120, settings.getSyncInterval());
		Assert.assertEquals("", settings.getScanDevice());
		Assert.assertEquals(0, settings.getScanFocus());
		Assert.assertEquals(0, settings.getScanMode());
		Assert.assertEquals(0, settings.getScanVibration());
		Assert.assertEquals(0, settings.getScanSound());
	}
}
