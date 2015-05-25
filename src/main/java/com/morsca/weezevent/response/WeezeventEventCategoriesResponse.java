package com.morsca.weezevent.response;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.morsca.weezevent.domain.WeezeventEventCategory;

public class WeezeventEventCategoriesResponse {

	@JsonFormat(pattern="yyyy-MM-dd'T'hh:mm:ssX")
	private Date lastUpdate;

	private Collection<WeezeventEventCategory> eventCategories;
	
	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Collection<WeezeventEventCategory> getEventCategories() {
		return eventCategories;
	}

	public void setEventCategories(Collection<WeezeventEventCategory> eventCategories) {
		this.eventCategories = eventCategories;
	}
	
}
