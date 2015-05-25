package com.morsca.weezevent.response;

import java.util.Collection;

import com.morsca.weezevent.domain.WeezeventEvent;

public class WeezeventEventsResponse {

	private Collection<WeezeventEvent> events;

	public Collection<WeezeventEvent> getEvents() {
		return events;
	}

	public void setEvents(Collection<WeezeventEvent> events) {
		this.events = events;
	}
	
}
