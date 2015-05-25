package com.morsca.weezevent.domain;

import java.util.Collection;

public class WeezeventCategory {

	private long id;
	
	private String name;
	
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
