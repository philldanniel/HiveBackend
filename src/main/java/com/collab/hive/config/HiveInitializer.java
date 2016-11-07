package com.collab.hive.config;

import javax.servlet.ServletRegistration;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HiveInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("dispatchOptionsRequest", "true");
		registration.setAsyncSupported(true);
	}
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HiveConfiguration.class, WebSocketConfig.class};
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { HiveConfiguration.class};
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    
    protected ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
	
  
}
