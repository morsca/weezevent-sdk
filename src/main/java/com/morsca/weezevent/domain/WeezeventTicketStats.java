package com.morsca.weezevent.domain;

public class WeezeventTicketStats {

	private long total;
	
	private long scanned;
	
	private long in;
	
	private long out;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getScanned() {
		return scanned;
	}

	public void setScanned(long scanned) {
		this.scanned = scanned;
	}

	public long getIn() {
		return in;
	}

	public void setIn(long in) {
		this.in = in;
	}

	public long getOut() {
		return out;
	}

	public void setOut(long out) {
		this.out = out;
	}
	
}
