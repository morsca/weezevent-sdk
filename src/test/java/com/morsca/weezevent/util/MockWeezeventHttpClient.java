package com.morsca.weezevent.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.morsca.weezevent.http.WeezeventHttpClient;

public class MockWeezeventHttpClient implements WeezeventHttpClient {

	private String lastUrl;
	
	private Map<String, Object> lastParams;
	
	private boolean justClosed;
	
	private String mockResult = "{}";
	
	private String accessToken = "f4b6b917cee00f13d57e3c84f56656b9";
	
	@Override
	public InputStream get(String url) throws IOException {
		lastUrl = url;
		lastParams = null;
		justClosed = false;
		return new ByteArrayInputStream(mockResult.getBytes());
	}

	@Override
	public InputStream get(String url, Map<String, Object> params) throws IOException {
		lastUrl = url;
		lastParams = params;
		justClosed = false;
		return new ByteArrayInputStream(mockResult.getBytes());
	}

	@Override
	public InputStream post(String url, Map<String, Object> params) throws IOException {
		lastUrl = url;
		lastParams = params;
		justClosed = false;
		
		if(url.endsWith("/auth/access_token")) {
			return new ByteArrayInputStream(new String("{\"accessToken\" : \"" + accessToken + "\"}").getBytes());
		}
		return new ByteArrayInputStream(mockResult.getBytes());
	}

	@Override
	public void close() throws IOException {
		lastUrl = null;
		lastParams = null;
		justClosed = true;
	}

	public String getLastUrl() {
		return lastUrl;
	}

	public Map<String, Object> getLastParams() {
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
	
}
