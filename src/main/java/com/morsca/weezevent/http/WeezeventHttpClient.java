package com.morsca.weezevent.http;

import java.util.Map;

import com.morsca.weezevent.exception.WeezeventException;

public interface WeezeventHttpClient {
	
	public abstract <T> T get(final String url, Class<T> clazz) throws WeezeventException;
	
	public abstract <T> T get(final String url, final Map<String, String> params, Class<T> clazz) throws WeezeventException;
	
	public abstract <T> T post(final String url, final Map<String, String> params, Class<T> clazz) throws WeezeventException;
	
	public abstract void close() throws WeezeventException;
	
}
