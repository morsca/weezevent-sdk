package com.morsca.weezevent;


import java.util.HashMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.morsca.weezevent.util.MockWeezeventHttpClient;

public class TestWeezeventClient {

	private WeezeventClient weezeventClient;
	
	private MockWeezeventHttpClient mockWeezeventHttpClient = new MockWeezeventHttpClient();
	
	private final static String API_KEY = "1234ABCD";
	
	@Before
	public void before() {
		weezeventClient = WeezeventClient.getWeezeventClient(API_KEY);
		weezeventClient.setWeezeventHttpClient(mockWeezeventHttpClient);
	}
	
	@After
	public void after() {
		weezeventClient.close();
	}
	
	@Test
	public void testGetWeezeventClientDoNotLogin() {
		weezeventClient.doNotLogin();
		
		Assert.assertNull(mockWeezeventHttpClient.getLastUrl());
		Assert.assertNull(mockWeezeventHttpClient.getLastParams());
	}
	
	@Test
	public void testGetWeezeventClientLogin() {
		weezeventClient.login("username", "password");
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/auth/access_token", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertEquals("username", mockWeezeventHttpClient.getLastParams().get("username"));
		Assert.assertEquals("password", mockWeezeventHttpClient.getLastParams().get("password"));
		Assert.assertEquals(API_KEY, mockWeezeventHttpClient.getLastParams().get("api_key"));
	}
	
	@Test
	public void testGetWeezeventClientLoginAndGet() {
		weezeventClient.login("username", "password");
		weezeventClient.get("/somewhere", Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/somewhere", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("access_token"));
		Assert.assertEquals(mockWeezeventHttpClient.getAccessToken(), mockWeezeventHttpClient.getLastParams().get("access_token"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("api_key"));
		Assert.assertEquals(API_KEY, mockWeezeventHttpClient.getLastParams().get("api_key"));
	}
	
	@Test
	public void testGetWeezeventClientLoginAndGetAndLogout() {
		weezeventClient.login("username", "password");
		weezeventClient.get("/somewhere", Object.class);
		weezeventClient.logout();
		
		Assert.assertFalse(mockWeezeventHttpClient.isJustClosed());
		
		weezeventClient.get("/somewhere", Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/somewhere", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("access_token"));
		Assert.assertNull(mockWeezeventHttpClient.getLastParams().get("access_token"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("api_key"));
		Assert.assertEquals(API_KEY, mockWeezeventHttpClient.getLastParams().get("api_key"));
	}
	
	@Test
	public void testGetWeezeventClientLoginAndGetAndLogoutAndClose() {
		weezeventClient.login("username", "password");
		weezeventClient.get("/somewhere", Object.class);
		weezeventClient.logout();
		weezeventClient.close();
		
		Assert.assertTrue(mockWeezeventHttpClient.isJustClosed());
	}
	
	@Test
	public void testGetAnonymously() {
		weezeventClient.getAnonymously("/mypath1", Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/mypath1", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNull(mockWeezeventHttpClient.getLastParams());
	}
	
	@Test
	public void testGet() {
		weezeventClient.get("/mypath2", Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/mypath2", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("access_token"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("api_key"));
	}
	
	@Test
	public void testGetWithParams() {
		String paramKey = "myparam1";
		String paramValue = "myvalue1";
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(paramKey, paramValue);
		weezeventClient.get("/mypath3", params, Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/mypath3", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("access_token"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("api_key"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey(paramKey));
		Assert.assertEquals(paramValue, mockWeezeventHttpClient.getLastParams().get(paramKey));
	}
	
	@Test
	public void testPostWithParams() {
		String paramKey = "myparam2";
		String paramValue = "myvalue2";
		
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put(paramKey, paramValue);
		weezeventClient.post("/mypath4", params, Object.class);
		
		Assert.assertEquals(WeezeventClient.DEFAULT_WEEZEVENT_URL + "/mypath4", mockWeezeventHttpClient.getLastUrl());
		Assert.assertNotNull(mockWeezeventHttpClient.getLastParams());
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("access_token"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey("api_key"));
		Assert.assertTrue(mockWeezeventHttpClient.getLastParams().containsKey(paramKey));
		Assert.assertEquals(paramValue, mockWeezeventHttpClient.getLastParams().get(paramKey));
	}
}
