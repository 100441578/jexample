package com.dev118.jexample.http.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HelloTest {

	@Test
	public void test() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost:8080/jexample.servlet/login.jsp");
		CloseableHttpResponse response = httpClient.execute(httpGet);
		System.out.println(response.getStatusLine());
		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);
		System.out.println(body);
		EntityUtils.consume(entity);
		response.close();
	}

	@Test
	public void testLogin() throws Exception {
		CloseableHttpClient httpClient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(
				"http://localhost:8080/jexample-servlet2/LoginServlet");
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("username", "admin"));
		nvps.add(new BasicNameValuePair("password", "admin"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response = httpClient.execute(httpPost);

		System.out.println(response.getStatusLine());

		HttpEntity entity = response.getEntity();
		String body = EntityUtils.toString(entity);

		System.out.println(body);
		EntityUtils.consume(entity);
		response.close();
	}

}
