package com.morsca.weezevent.response;

import java.util.Collection;

import com.morsca.weezevent.domain.WeezeventEventCategory;

public class WeezeventEventCategoriesResponse extends WeezeventLastUpdate {

	private Collection<WeezeventEventCategory> eventCategories;
	
	public Collection<WeezeventEventCategory> getEventCategories() {
		return eventCategories;
	}

	public void setEventCategories(Collection<WeezeventEventCategory> eventCategories) {
		this.eventCategories = eventCategories;
	}
	
}
