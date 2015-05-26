package com.morsca.weezevent.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morsca.weezevent.exception.WeezeventException;
import com.morsca.weezevent.mapper.WeezeventMapperFactory;

public class WeezeventApacheHttpClient implements WeezeventHttpClient {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	private ObjectMapper objectMapper = WeezeventMapperFactory.getWeezeventMapper();
	
	@Override
	public <T> T get(String url, Class<T> clazz) throws WeezeventException {
		try {
			InputStream is = get(url);
			return objectMapper.readValue(is, clazz);
		} catch(IOException e) {
			throw new WeezeventException(e);
		}
	}
	
	@Override
	public <T> T get(String url, Map<String, String> params, Class<T> clazz) throws WeezeventException {
		try {
			InputStream is = get(url, params);
			return objectMapper.readValue(is, clazz);
		} catch(IOException e) {
			throw new WeezeventException(e);
		}
	}
	
	@Override
	public <T> T post(String url, Map<String, String> params, Class<T> clazz) throws WeezeventException {
		try {
			InputStream is = post(url, params);
			return objectMapper.readValue(is, clazz);
		} catch(IOException e) {
			throw new WeezeventException(e);
		}
	}
	
	@Override
	public void close() throws WeezeventException {
		try {
			httpClient.close();
		} catch(IOException e) {
			throw new WeezeventException(e);
		}
	}
	
	private InputStream get(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}
	
	private InputStream get(String url, Map<String, String> params) throws IOException {
		HttpGet httpGet = new HttpGet(url + mapParamsToHttpRequestString(params));
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	private InputStream post(String url, Map<String, String> params) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		httpPost.setEntity(new UrlEncodedFormEntity(mapParamsToNameValuePairList(params)));
		HttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	
	private String mapParamsToHttpRequestString(Map<String, String> params) {
		if(params == null) return "";
		StringBuilder sb = new StringBuilder("?");
		for(Entry<String, String> entry : params.entrySet()) {
			sb.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
		}
		return sb.toString();
	}
	
	private List<NameValuePair> mapParamsToNameValuePairList(Map<String, String> params) {
		if(params == null) return Collections.emptyList();
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return nvps;
	}
	
}
