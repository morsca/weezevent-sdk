package com.morsca.weezevent.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface WeezeventHttpClient {

	public abstract InputStream get(final String url) throws IOException;
	
	public abstract InputStream get(final String url, final Map<String, Object> params) throws IOException;
	
	public abstract InputStream post(final String url, final Map<String, Object> params) throws IOException;
	
	public abstract void close() throws IOException;
	
}
