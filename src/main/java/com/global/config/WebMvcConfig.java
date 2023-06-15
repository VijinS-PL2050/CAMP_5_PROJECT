package com.global.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.global.interceptor.RestrictionInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Autowired
	private RestrictionInterceptor restrictionInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(restrictionInterceptor).addPathPatterns("/login/restricted-page");
	}
}
