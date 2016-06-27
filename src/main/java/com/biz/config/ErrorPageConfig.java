package com.biz.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Custom 에러페이지 정의
 * 
 * @author 엄승하  
 */
@Configuration
public class ErrorPageConfig implements EmbeddedServletContainerCustomizer {

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {

		ErrorPage error401 = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/notAuth");
		ErrorPage error403 = new ErrorPage(HttpStatus.FORBIDDEN, "/error/notAuth");
		ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/notFound");
		ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/serverError");

		container.addErrorPages(error401, error403, error404, error500);
	}

}
