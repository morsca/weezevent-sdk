package com.morsca.weezevent.response;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.morsca.weezevent.domain.WeezeventEventDetails;

public class WeezeventEventSearchResponse {

	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ssX")
	private Date lastUpdate;
	
	private long count;

	private Collection<WeezeventEventDetails> events;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

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
