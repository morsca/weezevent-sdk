package com.morsca.weezevent.domain;

public class WeezeventScanSettings {

	private String test;
	
	private long syncInterval;
	
	private String scanDevice;
	
	private long scanFocus;
	
	private long scanMode;
	
	private long scanVibration;
	
	private long scanSound;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public long getSyncInterval() {
		return syncInterval;
	}

	public void setSyncInterval(long syncInterval) {
		this.syncInterval = syncInterval;
	}

	public String getScanDevice() {
		return scanDevice;
	}

	public void setScanDevice(String scanDevice) {
		this.scanDevice = scanDevice;
	}

	public long getScanFocus() {
		return scanFocus;
	}

	public void setScanFocus(long scanFocus) {
		this.scanFocus = scanFocus;
	}

	public long getScanMode() {
		return scanMode;
	}

	public void setScanMode(long scanMode) {
		this.scanMode = scanMode;
	}

	public long getScanVibration() {
		return scanVibration;
	}

	public void setScanVibration(long scanVibration) {
		this.scanVibration = scanVibration;
	}

	public long getScanSound() {
		return scanSound;
	}

	public void setScanSound(long scanSound) {
		this.scanSound = scanSound;
	}
	
}
