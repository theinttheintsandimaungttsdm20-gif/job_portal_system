package com.jobportal.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SpringSecurityWebInitalizer extends AbstractSecurityWebApplicationInitializer {
	public SpringSecurityWebInitalizer(){
		System.out.println("SpringSecurityWebInitalizer Construtor");
	}
}
