package com.morsca.weezevent.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeezeventAuthAccessTokenResponse {

	@JsonProperty("accessToken")
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
