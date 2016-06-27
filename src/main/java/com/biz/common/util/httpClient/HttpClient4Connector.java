package com.biz.common.util.httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.PreDestroy;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * HTTP통신관련 클래스
 *  - http방식의 통신 각종 메소드를 지원  
 * 
 * @author 엄승하
 */
public class HttpClient4Connector implements ResourceConnector {
	private HttpClient httpClient;
	private PoolingHttpClientConnectionManager connManager;

	/**
	 * 리소스 릴리즈
	 */
	@PreDestroy
	public void releaseConnectionPool() {
		connManager.shutdown();
	}

	/**
	 * Commons http client4를 이용한 커넥터
	 * 
	 * @param connectTimeoutMilsec connectTimeoutMilsec
	 * @param readTimeoutMilsec readTimeoutMilsec
	 */
	public HttpClient4Connector(int connectTimeoutMilsec, int readTimeoutMilsec) {

		connManager = new PoolingHttpClientConnectionManager();
		connManager.setMaxTotal(40);
		connManager.setDefaultMaxPerRoute(20);

		//리퀘스트 빌더 - 타임아웃 설정
		RequestConfig.Builder requestBuilder = RequestConfig.custom();
		requestBuilder.setConnectTimeout(connectTimeoutMilsec);
		requestBuilder.setConnectionRequestTimeout(readTimeoutMilsec);
		requestBuilder.setSocketTimeout(connectTimeoutMilsec);

		//클라이언트 빌더 - 커넥션 매니저, 리퀘스트 컨피그 설정
		HttpClientBuilder httpBulider = HttpClientBuilder.create();
		httpBulider.setConnectionManager(connManager);
		httpBulider.setDefaultRequestConfig(requestBuilder.build());

		HttpClient client = httpBulider.build();
		this.httpClient = client;
	}

	/**
	 * HTTP GET으로 URL에 요청
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	@Override
	public InputStream openGet(String url) throws IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

	/**
	 * HTTP GET요청 후 응답 상태코드를 리턴
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Override
	public int openGetAndRtnStatusCd(String url) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);
		return response.getStatusLine().getStatusCode();
	}

	/**
	 * HTTP GET요청 후 HttpResponse 객체를 리턴
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Override
	public HttpResponse openGetAndRtnHttpResponseObj(String url) throws ClientProtocolException, IOException {
		HttpGet request = new HttpGet(url);
		return httpClient.execute(request);
	}

	/**
	 * HTTP POST로 URL에 요청
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	@Override
	public InputStream openPost(String url, List<NameValuePair> params) throws IOException {
		HttpPost request = new HttpPost(url);

		request.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		return entity.getContent();
	}

}
