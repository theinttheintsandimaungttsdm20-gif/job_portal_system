package com.jobportal.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml
public class WebXml extends AbstractAnnotationConfigDispatcherServletInitializer{
	//<listener>
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("WebXML-->getRootConfigClasses:SpringConfig");
		return new Class[]{SpringConfigXml.class,SpringSecurityWebInitalizer.class,
				SpringSecurityXmlConfig.class};
	}

	//<servlet>
	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("WebXML-->getServletConfigClasses:SpringServlet");
		return new Class[]{SpringServletXml.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("WebXML-->getServletMappings");
		return new String[]{"/"};
	}
	
	 @Override
		protected void customizeRegistration(ServletRegistration.Dynamic registration) {
	    	registration.setMultipartConfig(getMultipartConfigElement());
		}

	    private MultipartConfigElement getMultipartConfigElement(){
			MultipartConfigElement multipartConfigElement = new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
			return multipartConfigElement;
		}
	    
	    /*Set these variables for your project needs*/ 
	    
		private static final String LOCATION = "D:/MyaTheint/";

		private static final long MAX_FILE_SIZE = 1024 * 1024 * 25;//25MB
		
		private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 30;//30MB

	    private static final int FILE_SIZE_THRESHOLD = 0;

}
