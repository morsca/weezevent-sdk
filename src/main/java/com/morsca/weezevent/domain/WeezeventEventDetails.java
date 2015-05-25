package com.morsca.weezevent.domain;

import java.util.Collection;
import java.util.Map;

public class WeezeventEventDetails {

	private long id;
	
	private String title;
	
	private String siteUrl;
	
	private String description;
	
	private String image;
	
	private WeezeventCategory category;
	
	private WeezeventPeriod period;
	
	private WeezeventPriceInterval price;
	
	private WeezeventVenue venue;
	
	private Map<String, String> extras;
	
	private WeezeventPeriod salePeriod;
	
	private Collection<WeezeventPeriod> dates;
	
	private WeezeventOrganizer organizer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSiteUrl() {
		return siteUrl;
	}

	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public WeezeventCategory getCategory() {
		return category;
	}

	public void setCategory(WeezeventCategory category) {
		this.category = category;
	}

	public WeezeventPeriod getPeriod() {
		return period;
	}

	public void setPeriod(WeezeventPeriod period) {
		this.period = period;
	}

	public WeezeventPriceInterval getPrice() {
		return price;
	}

	public void setPrice(WeezeventPriceInterval price) {
		this.price = price;
	}

	public WeezeventVenue getVenue() {
		return venue;
	}

	public void setVenue(WeezeventVenue venue) {
		this.venue = venue;
	}

	public Map<String, String> getExtras() {
		return extras;
	}

	public void setExtras(Map<String, String> extras) {
		this.extras = extras;
	}

	public WeezeventPeriod getSalePeriod() {
		return salePeriod;
	}

	public void setSalePeriod(WeezeventPeriod salePeriod) {
		this.salePeriod = salePeriod;
	}

	public Collection<WeezeventPeriod> getDates() {
		return dates;
	}

	public void setDates(Collection<WeezeventPeriod> dates) {
		this.dates = dates;
	}

	public WeezeventOrganizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(WeezeventOrganizer organizer) {
		this.organizer = organizer;
	}
	
}
