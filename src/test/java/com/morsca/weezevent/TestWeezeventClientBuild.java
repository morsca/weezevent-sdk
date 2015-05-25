package com.morsca.weezevent;


import org.junit.Assert;
import org.junit.Test;

public class TestWeezeventClientBuild {

	@Test
	public void testDefaultBuild() {
		WeezeventClient weezeventClient = WeezeventClient.getWeezeventClient();
		 
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL, weezeventClient.getUrl());
		Assert.assertNull(weezeventClient.getApiKey());
	}
	
	@Test
	public void testApiKeyBuild() {
		String apiKey = "9F93KF7ZN";
		WeezeventClient weezeventClient = WeezeventClient.getWeezeventClient(apiKey);
		 
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL, weezeventClient.getUrl());
		Assert.assertEquals(apiKey, weezeventClient.getApiKey());
	}
	
	@Test
	public void testApiKeyAndUrlBuild() {
		String apiKey = "9F93KF7ZN";
		String url = "http://someserver.somedomain.tld";
		WeezeventClient weezeventClient = WeezeventClient.getWeezeventClient(url, apiKey);
		 
		Assert.assertEquals(url, weezeventClient.getUrl());
		Assert.assertEquals(apiKey, weezeventClient.getApiKey());
	}
	
}
