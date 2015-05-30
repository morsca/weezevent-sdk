package com.morsca.weezevent.response;

import java.util.Collection;

import com.morsca.weezevent.domain.WeezeventEventDetails;

public class WeezeventEventSearchResponse extends WeezeventLastUpdate {

	private long count;

	private Collection<WeezeventEventDetails> events;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Collection<WeezeventEventDetails> getEvents() {
		return events;
	}

	public void setEvents(Collection<WeezeventEventDetails> events) {
		this.events = events;
	}
	
}
