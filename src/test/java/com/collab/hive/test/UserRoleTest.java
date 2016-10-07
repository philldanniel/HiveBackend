package com.collab.hive.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.collab.hive.dao.RoleDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.dao.UserRoleDAO;
import com.collab.hive.model.Role;
import com.collab.hive.model.UserDetails;
import com.collab.hive.model.UserRole;

public class UserRoleTest {

	public static void main(String[] args) {
		/*ApplicationContext factory*/ 
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
		
		UserRoleDAO userRoleDAO = factory.getBean(UserRoleDAO.class);
		RoleDAO roleDAO = factory.getBean(RoleDAO.class);
		/*Role role = roleDAO.get(5);
		UserDetailsDAO userDetailsDAO = factory.getBean(UserDetailsDAO.class);
		UserDetails userDetails = userDetailsDAO.get("phill");
		
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUserDetails(userDetails);
		userRoleDAO.saveOrUpdate(userRole);*/
		
		/*userRoleDAO.delete(41);*/
		
		/*UserRole userRole = userRoleDAO.get(5);
		System.out.println("UserRole:-"+ userRole.getUserRole_name());
		System.out.println("UserRole list size:-"+ userRoleDAO.list().size());*/
		
		Role role = roleDAO.getRoleByName("STUDENT");
		System.out.println("Role-id: " + role.getRole_id());
		System.out.println("Role-name: " + role.getRole_name());
		factory.close();

	}

}
