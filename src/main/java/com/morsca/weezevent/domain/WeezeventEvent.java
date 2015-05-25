package com.morsca.weezevent.domain;

import java.util.Collection;

public class WeezeventEvent {

	private long id;
	
	private String name;
	
	private WeezeventPeriod date;
	
	private long participants;
	
	private long multipleDates;

	private Collection<WeezeventTicket> tickets;
	
	private Collection<WeezeventCategory> categories;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WeezeventPeriod getDate() {
		return date;
	}

	public void setDate(WeezeventPeriod date) {
		this.date = date;
	}

	public long getParticipants() {
		return participants;
	}

	public void setParticipants(long participants) {
		this.participants = participants;
	}

	public long getMultipleDates() {
		return multipleDates;
	}

	public void setMultipleDates(long multipleDates) {
		this.multipleDates = multipleDates;
	}

	public Collection<WeezeventTicket> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<WeezeventTicket> tickets) {
		this.tickets = tickets;
	}

	public Collection<WeezeventCategory> getCategories() {
		return categories;
	}

	public void setCategories(Collection<WeezeventCategory> categories) {
		this.categories = categories;
	}
	
}
