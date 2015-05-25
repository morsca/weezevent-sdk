package com.morsca.weezevent.domain;

public class WeezeventTicket {

	private String id;
	
	private String name;
	
	private double price;
	
	private long participants;
	
	private long quota;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getParticipants() {
		return participants;
	}

	public void setParticipants(long participants) {
		this.participants = participants;
	}

	public long getQuota() {
		return quota;
	}

	public void setQuota(long quota) {
		this.quota = quota;
	}
	
}
