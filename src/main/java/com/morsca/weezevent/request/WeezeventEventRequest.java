package com.morsca.weezevent.request;

public class WeezeventEventRequest {

	private Boolean includeNotPublished;
	
	private Boolean includeClosed;
	
	private Boolean includeWithoutSales;

	public Boolean getIncludeNotPublished() {
		return includeNotPublished;
	}

	public void setIncludeNotPublished(Boolean includeNotPublished) {
		this.includeNotPublished = includeNotPublished;
	}

	public Boolean getIncludeClosed() {
		return includeClosed;
	}

	public void setIncludeClosed(Boolean includeClosed) {
		this.includeClosed = includeClosed;
	}

	public Boolean getIncludeWithoutSales() {
		return includeWithoutSales;
	}

	public void setIncludeWithoutSales(Boolean includeWithoutSales) {
		this.includeWithoutSales = includeWithoutSales;
	}
	
}
