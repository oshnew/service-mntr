package com.biz.config;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.biz.config.sitemesh.SiteMeshFilter;

/**
 * Servlet Class
 * 
 * @author 엄승하
 *
 */
@Configuration
public class ServletInitializer extends SpringBootServletInitializer {

	/**
	 * 필터 등록
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean filterRegistration() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new SiteMeshFilter()); //sitemesh 필터

		return filter;
	}
}
