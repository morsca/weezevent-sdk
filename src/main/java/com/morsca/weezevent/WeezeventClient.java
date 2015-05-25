package com.morsca.weezevent;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morsca.weezevent.http.WeezeventApacheHttpClient;
import com.morsca.weezevent.http.WeezeventHttpClient;
import com.morsca.weezevent.mapper.WeezeventMapperFactory;
import com.morsca.weezevent.response.WeezeventAuthAccessTokenResponse;

public class WeezeventClient {

	public final static String DEFAULT_WEEZEVENT_URL = "https://api.weezevent.com";
	
	private ObjectMapper objectMapper = WeezeventMapperFactory.getWeezeventMapper();
	
	private WeezeventHttpClient weezeventHttpClient = new WeezeventApacheHttpClient();
	
	private String url;
	
	private String apiKey;
	
	private String accessToken;
	
	private WeezeventClient() {}
	
	public String getUrl() {
		return url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public ObjectMapper getObjectMapper() {
		return objectMapper;
	}

	public void setObjectMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	public WeezeventHttpClient getWeezeventHttpClient() {
		return weezeventHttpClient;
	}

	public void setWeezeventHttpClient(WeezeventHttpClient weezeventHttpClient) {
		this.weezeventHttpClient = weezeventHttpClient;
	}
	
	public WeezeventService doNotLogin() {
		return new WeezeventService(this);
	}

	public WeezeventService login(final String username, final String password) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		params.put("password", password);
		params.put("api_key", apiKey);
		WeezeventAuthAccessTokenResponse tokenResponse = 
				post("/auth/access_token", params, WeezeventAuthAccessTokenResponse.class);
		accessToken = tokenResponse.getAccessToken();
		return new WeezeventService(this);
	}
	
	public void logout() {
		accessToken = null;
	}
	
	public void close() {
		logout();
		
		try {
			weezeventHttpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static WeezeventClient getWeezeventClient() {
		return getWeezeventClient(DEFAULT_WEEZEVENT_URL, null);
	}
	
	public static WeezeventClient getWeezeventClient(final String apiKey) {
		return getWeezeventClient(DEFAULT_WEEZEVENT_URL, apiKey);
	}
	
	public static WeezeventClient getWeezeventClient(final String url, final String apiKey) {
		WeezeventClient weezeventClient = new WeezeventClient();
		weezeventClient.url = url;
		weezeventClient.apiKey = apiKey;
		return weezeventClient;
	}
	
	public <T> T getAnonymously(final String path, Class<T> clazz) {
		try {
			InputStream is = weezeventHttpClient.get(url + path);
			return objectMapper.readValue(is, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T get(final String path, Class<T> clazz) {
		return get(path, new HashMap<String, Object>(), clazz);
	}
	
	public <T> T get(final String path, final Map<String, Object> params, Class<T> clazz) {
		params.put("access_token", accessToken);
		params.put("api_key", apiKey);
		
		try {
			InputStream is = weezeventHttpClient.get(url + path, params);
			return objectMapper.readValue(is, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public <T> T post(final String path, final Map<String, Object> params, Class<T> clazz) {
		params.put("access_token", accessToken);
		params.put("api_key", apiKey);
		
		try {
			InputStream is = weezeventHttpClient.post(url + path, params);
			return objectMapper.readValue(is, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
