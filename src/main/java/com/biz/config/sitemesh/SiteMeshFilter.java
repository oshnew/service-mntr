package com.biz.config.sitemesh;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Custom SiteMeshFiler class    
 * 
 * @author 엄승하
 *
 */
public class SiteMeshFilter extends ConfigurableSiteMeshFilter {

	/**
	 * Decorator Setting
	 * 
	 * @param builder
	 */
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/WEB-INF/decorators/defaultDecorator.jsp").addExcludedPath("/api/**").addExcludedPath(
			"/resources/**").addExcludedPath("/test/**").addExcludedPath("/systemCheck/**");
	}

}
