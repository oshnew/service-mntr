package com.biz.common.util.httpClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

/**
 * HTTP 리소스 커넥터 인터페이스
 * 
 * @author 엄승하
 */
public interface ResourceConnector {

	/**
	 * HTTP GET으로 URL에 요청
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public InputStream openGet(String url) throws IOException;

	/**
	 * HTTP POST로 URL에 요청
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public InputStream openPost(String url, List<NameValuePair> params) throws IOException;

	/**
	 * HTTP GET요청 후 응답 상태코드를 리턴
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public int openGetAndRtnStatusCd(String url) throws ClientProtocolException, IOException;

	/**
	 * HTTP GET요청 후 HttpResponse 객체를 리턴
	 * 
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResponse openGetAndRtnHttpResponseObj(String url) throws ClientProtocolException, IOException;

}
