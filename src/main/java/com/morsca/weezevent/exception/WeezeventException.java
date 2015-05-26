package com.morsca.weezevent.exception;

public class WeezeventException extends Exception {

	private static final long serialVersionUID = 5170756624774153863L;

	public WeezeventException(String message) {
		super(message);
	}
	
	public WeezeventException(Throwable cause) {
		super(cause);
	}
	
	public WeezeventException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
