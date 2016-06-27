package com.biz.common.util.httpClient;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

/**
 * HttpComponentsClientHttpRequestFactory Factory Class
 *  - thread safe initalization sington
 *  - https://blog.seotory.com/post/2016/03/java-singleton-pattern
 *  
 * @author 엄승하
 *
 */
public class HttpRequestFactory {
    private static HttpComponentsClientHttpRequestFactory factory;

    private final static int TIME_OUT = 2000; //2초

    private HttpRequestFactory() { //기본 생성자 막기
        throw new IllegalAccessError();
    }

    /**
     * getInstance
     * 
     * @return
     */
    public static synchronized HttpComponentsClientHttpRequestFactory getInstance() {

        if (factory == null) {
            factory = new HttpComponentsClientHttpRequestFactory();
            factory.setReadTimeout(TIME_OUT); //소켓 타임아웃(2초)
            factory.setConnectTimeout(TIME_OUT); //커넥션 타임아웃(2초)
        }

        return factory;
    }

}
