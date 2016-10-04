package com.collab.hive.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.UserDetails;
import com.collab.hive.model.UserDetails;

public class UserDetailsTest {

	public static void main(String[] args) {
		/*ApplicationContext factory*/ 
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
		
		UserDetailsDAO userDetailsDAO = factory.getBean(UserDetailsDAO.class);
		UserDetails userDetails = new UserDetails();
		userDetails.setUser_id("dhaneesh");
		userDetails.setEmail_id("dhaneesh@rvngd.com");
		userDetails.setFirst_name("Dhaneesh");
		userDetails.setLast_name("Pillai");
		userDetails.setMobile_no("9867514293");
		userDetails.setPassword("123456");
		userDetails.setStatus(0);
		userDetailsDAO.saveOrUpdate(userDetails);
		
		/*userDetailsDAO.delete("rvngd");*/
		
		/*UserDetails userDetails = userDetailsDAO.get("rvngd");
		System.out.println("UserDetails:-"+ userDetails.getFirst_name());
		System.out.println("UserDetails list size:-"+ userDetailsDAO.list().size());*/
		
		/*String id = "rvngd";
		String password = "123456";
		System.out.println("Is the user valid = " + userDetailsDAO.isValidUser(id, password) );*/
		
		factory.close();

	}

}
