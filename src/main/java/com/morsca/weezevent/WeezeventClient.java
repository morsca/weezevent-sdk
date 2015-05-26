package com.morsca.weezevent;

import java.util.HashMap;
import java.util.Map;

import com.morsca.weezevent.exception.WeezeventException;
import com.morsca.weezevent.http.WeezeventApacheHttpClient;
import com.morsca.weezevent.http.WeezeventHttpClient;
import com.morsca.weezevent.response.WeezeventAuthAccessTokenResponse;

public class WeezeventClient {

	public final static String DEFAULT_WEEZEVENT_URL = "https://api.weezevent.com";
	
	private WeezeventHttpClient weezeventHttpClient = new WeezeventApacheHttpClient();
	
	private String url;
	
	private String apiKey;
	
	private String accessToken;
	
	protected WeezeventClient() {}
	
	public String getUrl() {
		return url;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getAccessToken() {
		return accessToken;
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

	public WeezeventService login(final String username, final String password) throws WeezeventException {
		HashMap<String, String> params = new HashMap<String, String>();
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
	
	public void close() throws WeezeventException {
		logout();
		weezeventHttpClient.close();
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
	
	public <T> T getAnonymously(final String path, Class<T> clazz) throws WeezeventException {
		return weezeventHttpClient.get(url + path, clazz);
	}
	
	public <T> T get(final String path, Class<T> clazz) throws WeezeventException {
		return get(path, new HashMap<String, String>(), clazz);
	}
	
	public <T> T get(final String path, final Map<String, String> params, Class<T> clazz) throws WeezeventException {
		params.put("access_token", accessToken);
		params.put("api_key", apiKey);
		return weezeventHttpClient.get(url + path, params, clazz);
	}
	
	public <T> T post(final String path, final Map<String, String> params, Class<T> clazz) throws WeezeventException {
		params.put("access_token", accessToken);
		params.put("api_key", apiKey);
		return weezeventHttpClient.post(url + path, params, clazz);
	}

}
