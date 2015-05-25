package com.morsca.weezevent.domain;

public class WeezeventLocation {

	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String state;
	
	private WeezeventCountry country;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public WeezeventCountry getCountry() {
		return country;
	}

	public void setCountry(WeezeventCountry country) {
		this.country = country;
	}
	
}
