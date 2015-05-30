package com.morsca.weezevent.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public abstract class WeezeventLastUpdate {

	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ssX")
	private Date lastUpdate;

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
}
