package com.morsca.weezevent.domain;

import java.util.Date;

public class WeezeventParticipantControlStatus {

	private long status;
	
	private Date scanDate;
	
	private long scanUser;
	
	private String scanUserName;

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Date getScanDate() {
		return scanDate;
	}

	public void setScanDate(Date scanDate) {
		this.scanDate = scanDate;
	}

	public long getScanUser() {
		return scanUser;
	}

	public void setScanUser(long scanUser) {
		this.scanUser = scanUser;
	}

	public String getScanUserName() {
		return scanUserName;
	}

	public void setScanUserName(String scanUserName) {
		this.scanUserName = scanUserName;
	}
	
}
