package com.morsca.weezevent.response;

import com.morsca.weezevent.domain.WeezeventEventDetails;

public class WeezeventEventDetailsResponse extends WeezeventLastUpdate {

	private WeezeventEventDetails events;

	public WeezeventEventDetails getEvents() {
		return events;
	}

	public void setEvents(WeezeventEventDetails events) {
		this.events = events;
	}
	
}
