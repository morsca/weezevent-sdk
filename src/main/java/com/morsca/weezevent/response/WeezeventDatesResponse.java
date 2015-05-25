package com.morsca.weezevent.response;

import java.util.Collection;

import com.morsca.weezevent.domain.WeezeventDate;

public class WeezeventDatesResponse {

	private Collection<WeezeventDate> dates;

	public Collection<WeezeventDate> getDates() {
		return dates;
	}

	public void setDates(Collection<WeezeventDate> dates) {
		this.dates = dates;
	}
	
}
