package com.sk.cicdtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

/**
 * @author Rupali
 * @author Shesho
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer{
	
	@Value("${spring.allowed.origin}")
	public String allowedOrigin;
 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOriginPatterns(allowedOrigin)
			.allowedHeaders("*")
			.allowedMethods("GET", "POST")
			.allowCredentials(true)
			.maxAge(3600);
	}
	
	
	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}