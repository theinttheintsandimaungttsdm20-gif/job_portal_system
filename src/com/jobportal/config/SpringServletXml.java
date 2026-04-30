package com.jobportal.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableScheduling
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.jobportal"})
public class SpringServletXml implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("SpringServletXML-->addResourceHandlers");
		registry
		.addResourceHandler("/resources/**")
		.addResourceLocations("/resources/");
	}

	@Bean //View Bean
	public InternalResourceViewResolver resolver(){
		System.out.println("SpringServletXML-->Internal View Resolber");
		InternalResourceViewResolver
			res=new InternalResourceViewResolver();
		res.setPrefix("/WEB-INF/views/");
		res.setSuffix(".jsp");
		return res;
	}
	
	@Bean(name="multipartResolver")
	public StandardServletMultipartResolver resolver1(){
		return new StandardServletMultipartResolver();
	}
	
//	  @Bean
//		public MessageSource messageSource() {
//		    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		    messageSource.setBasename("messages");
//		    return messageSource;
//		}
	  
		@Bean
		public MessageSource messageSource() {
		    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		    source.setBasename("i18n/messages");
		    source.setDefaultEncoding("UTF-8");
		    return source;
		}
	    
	    /**Optional. It's only required when handling '.' in @PathVariables which otherwise ignore everything after last '.' in @PathVaidables argument.
	     * It's a known bug in Spring [https://jira.spring.io/browse/SPR-6164], still present in Spring 4.1.7.
	     * This is a workaround for this issue.
	     */
	    @Override
	    public void configurePathMatch(PathMatchConfigurer matcher) {
	        matcher.setUseRegisteredSuffixPatternMatch(true);
	    }
	    
}




