package com.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * 스프링부트 메인(시작시점) 어플리케이션
 *
 * @author 엄승하  
 */
@PropertySource(value = {"global_common.properties", "properties/common.properties", "properties/email.properties",})
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ImportResource({"classpath:context-common.xml", "classpath:context-datasource.xml", "classpath:context-mybatis-mapper.xml"})
public class StartMainApplication {

	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(StartMainApplication.class);
	}
}
