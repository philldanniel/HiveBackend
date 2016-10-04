package com.collab.hive.test;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.collab.hive.dao.BlogDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.Blog;
import com.collab.hive.model.UserDetails;

public class BlogTest {

	public static void main(String[] args) {
		/*ApplicationContext factory*/ 
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
		
		BlogDAO blogDAO = factory.getBean(BlogDAO.class);
		UserDetailsDAO userDetailsDAO = factory.getBean(UserDetailsDAO.class);
		Blog blog = new Blog();
		blog.setBlog_name("Second blog");
		blog.setBlog("This is my second blog.");
		blog.setStatus(0);
		DateTime dt = new DateTime();
		blog.setBlog_date(dt);
		UserDetails userDetails = userDetailsDAO.get("rvngd");
		blog.setBlogger(userDetails);
		blogDAO.saveOrUpdate(blog);
		
		/*blogDAO.delete(1);*/
		
		/*Blog blog = blogDAO.get(5);
		System.out.println("Blog:-"+ blog.getBlog_name());
		System.out.println("Blog list size:-"+ blogDAO.list().size());
		UserDetails user = blog.getBlogger();
		System.out.println("Blogger:" + user.getFirst_name());*/
		
		
		factory.close();

	}

}
