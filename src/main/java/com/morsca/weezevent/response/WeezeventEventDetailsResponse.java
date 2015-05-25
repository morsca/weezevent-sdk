package com.morsca.weezevent.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.morsca.weezevent.domain.WeezeventEventDetails;

public class WeezeventEventDetailsResponse {

	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ssX")
	private Date lastUpdate;
	
	private WeezeventEventDetails events;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public WeezeventEventDetails getEvents() {
		return events;
	}

	public void setEvents(WeezeventEventDetails events) {
		this.events = events;
	}
	
}
