package com.collab.hive.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class HiveInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { HiveConfiguration.class/*,factory.getClass()*/};
    }
   
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
   
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
    
    
    protected ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
	
  
}
