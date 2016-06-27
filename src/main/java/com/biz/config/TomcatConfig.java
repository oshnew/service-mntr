package com.biz.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * embedded톰캣 설정
 * 
 * @author 엄승하
 *
 */
@Configuration
public class TomcatConfig {

	@Bean
	public EmbeddedServletContainerFactory getEmbeddedServletContainerFactory() {

		TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory();
		containerFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {

			@Override
			public void customize(Connector connector) {
				//((AbstractProtocol<?>)connector.getProtocolHandler()).setKeepAliveTimeout(-1); //nginx -> 톰캣 keep alive 무제한
				((AbstractProtocol<?>)connector.getProtocolHandler()).setConnectionTimeout(5000);
			}
		});

		return containerFactory;
	}
}