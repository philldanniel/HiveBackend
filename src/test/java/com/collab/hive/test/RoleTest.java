package com.collab.hive.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.collab.hive.dao.RoleDAO;
import com.collab.hive.model.Role;

public class RoleTest {

	public static void main(String[] args) {
		/*ApplicationContext factory*/ 
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
		
		RoleDAO roleDAO = factory.getBean(RoleDAO.class);
		Role role = new Role();
		role.setRole_name("ALUMNI");
		roleDAO.saveOrUpdate(role);
		
		/*roleDAO.delete(3);*/
		
		/*Role role = roleDAO.get(5);
		System.out.println("Role:-"+ role.getRole_name());
		System.out.println("Role list size:-"+ roleDAO.list().size());*/
		
		factory.close();

	}

}
