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

public class WeezeventApacheHttpClient implements WeezeventHttpClient {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();
	
	@Override
	public InputStream get(String url) throws IOException {
		HttpGet httpGet = new HttpGet(url);
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}
	
	@Override
	public InputStream get(String url, Map<String, Object> params) throws IOException {
		HttpGet httpGet = new HttpGet(url + mapParamsToHttpRequestString(params));
		HttpResponse response = httpClient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	@Override
	public InputStream post(String url, Map<String, Object> params) throws IOException {
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8");
		httpPost.setEntity(new UrlEncodedFormEntity(mapParamsToNameValuePairList(params)));
		HttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}
	
	private String mapParamsToHttpRequestString(Map<String, Object> params) {
		if(params == null) return "";
		StringBuilder sb = new StringBuilder("?");
		for(Entry<String, Object> entry : params.entrySet()) {
			sb.append(entry.getKey()).append('=').append(entry.getValue()).append('&');
		}
		return sb.toString();
	}
	
	private List<NameValuePair> mapParamsToNameValuePairList(Map<String, Object> params) {
		if(params == null) return Collections.emptyList();
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		for(Entry<String, Object> entry : params.entrySet()) {
			nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		}
		return nvps;
	}
	
}
