package com.morsca.weezevent.serialization;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morsca.weezevent.response.WeezeventScanUserResponse;

public class TestWeezeventGetScanUser {

	private final ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void testWeezeventGetScanUser() throws Exception {
		WeezeventScanUserResponse scanUserResponse = mapper.readValue(ClassLoader.getSystemResourceAsStream("getScanUser.json"), WeezeventScanUserResponse.class);
		
		Assert.assertNotNull(scanUserResponse);
		Assert.assertEquals(1789, scanUserResponse.getId());
	}
}
