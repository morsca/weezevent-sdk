package com.morsca.weezevent.mock;

import java.util.Map;

import com.morsca.weezevent.exception.WeezeventException;
import com.morsca.weezevent.response.WeezeventAuthAccessTokenResponse;

public class WeezeventHttpClient implements com.morsca.weezevent.http.WeezeventHttpClient {

	private String lastUrl;
	
	private Map<String, String> lastParams;
	
	private boolean justClosed;
	
	private String accessToken = "f4b6b917cee00f13d57e3c84f56656b9";
	
	@Override
	public <T> T get(String url, Class<T> clazz) throws WeezeventException {
		lastUrl = url;
		lastParams = null;
		justClosed = false;
		return getInstance(clazz);
	}
	
	@Override
	public <T> T get(String url, Map<String, String> params, Class<T> clazz) throws WeezeventException {
		lastUrl = url;
		lastParams = params;
		justClosed = false;
		return getInstance(clazz);
	}
	
	@Override
	public <T> T post(String url, Map<String, String> params, Class<T> clazz) throws WeezeventException {
		lastUrl = url;
		lastParams = params;
		justClosed = false;
		
		T response = getInstance(clazz);
		if(url.endsWith("/auth/access_token") && response instanceof WeezeventAuthAccessTokenResponse) {
			((WeezeventAuthAccessTokenResponse) response).setAccessToken(accessToken);
			return response;
		}
		return getInstance(clazz);
	}
	
	@Override
	public void close() throws WeezeventException {
		lastUrl = null;
		lastParams = null;
		justClosed = true;
	}

	public String getLastUrl() {
		return lastUrl;
	}

	public Map<String, String> getLastParams() {
		return lastParams;
	}

	public boolean isJustClosed() {
		return justClosed;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	private <T> T getInstance(Class<T> clazz) throws WeezeventException {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			throw new WeezeventException(e);
		}
	}
	
}
