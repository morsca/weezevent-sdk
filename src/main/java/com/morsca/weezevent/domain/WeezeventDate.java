package com.morsca.weezevent.domain;

import java.util.Collection;
import java.util.Date;

public class WeezeventDate {

	private long id;
	
	private long idEvent;
	
	private Date date;
	
	private Collection<Long> tickets;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(long idEvent) {
		this.idEvent = idEvent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<Long> getTickets() {
		return tickets;
	}

	public void setTickets(Collection<Long> tickets) {
		this.tickets = tickets;
	}
	
}
