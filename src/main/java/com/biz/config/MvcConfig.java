package com.biz.config;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.biz.common.interceptor.WebAccessInterceptor;

/**
 * MVC 관련 config class
 * 
 * @author 엄승하
 *
 */
@ComponentScan(basePackages = {"com.biz"}, includeFilters = {@Filter(value = org.springframework.stereotype.Controller.class)})
@EnableCaching /* 캐쉬관련 */
@EnableWebMvc
@Configuration
@EnableAsync
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * 정적자원 세팅
	 * 
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/").setCachePeriod(3600).resourceChain(true).addResolver(new PathResourceResolver());
		registry.addResourceHandler("/robots.txt").addResourceLocations("/");
		registry.addResourceHandler("/favicon.ico").addResourceLocations("/resources/favicon.ico");
	}

	/**
	 * view Resolver
	 * 
	 * @return
	 */
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	/**
	 * Web Front페이지가 존재하는 요청의 인터셉터 bean 가져오기
	 * 
	 * @return
	 */
	@Bean
	public WebAccessInterceptor getBeanWebPageReqInterceptor() {
		return new WebAccessInterceptor();
	}

	/**
	 * 스레드풀 설정
	 * 
	 * @return
	 */
	@Bean
	public TaskExecutor taskExecutor() {

		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setThreadNamePrefix("mntr-task-executor-");
		executor.setCorePoolSize(20);
		executor.setMaxPoolSize(500); //최대 스레드풀 500
		executor.setQueueCapacity(200); //큐 200
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy()); //큐와 스레드에 가득차면 예외발생하고 무효됨

		return executor;
	}

	/**
	* MessageSourceAccessor 설정
	* 
	* @param messageSource
	* @return
	*/
	@Bean
	public MessageSourceAccessor messageSourceAccessor(MessageSource messageSource) {
		MessageSourceAccessor messageSourceAccessor = new MessageSourceAccessor(messageSource);
		return messageSourceAccessor;
	}

	/**
	 * MessageSource 설정
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:/message/message", "classpath:/global_common", "classpath:/receipt/receipt", "classpath:/properties/common",
			"classpath:/properties/coupon", "classpath:/properties/email", "classpath:/properties/logback", "classpath:/properties/mongodb", "classpath:/properties/push");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		messageSource.setCacheSeconds(60);
		return messageSource;
	}

}
