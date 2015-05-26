package com.morsca.weezevent.mock;


public class WeezeventClient extends com.morsca.weezevent.WeezeventClient {

	public static WeezeventClient getWeezeventClient() {
		return getWeezeventClient(DEFAULT_WEEZEVENT_URL, null);
	}
	
	public static WeezeventClient getWeezeventClient(final String apiKey) {
		return getWeezeventClient(DEFAULT_WEEZEVENT_URL, apiKey);
	}
	
	public static WeezeventClient getWeezeventClient(final String url, final String apiKey) {
		WeezeventClient weezeventClient = new WeezeventClient();
		weezeventClient.setWeezeventHttpClient(new WeezeventHttpClient());
		return weezeventClient;
	}
	
}
