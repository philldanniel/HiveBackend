package com.collab.hive.test;

import org.joda.time.DateTime;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.collab.hive.dao.BlogCommentDAO;
import com.collab.hive.dao.BlogDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.Blog;
import com.collab.hive.model.BlogComment;

public class BlogCommentTest {

	public static void main(String[] args) {
		/*ApplicationContext factory*/ 
		ClassPathXmlApplicationContext factory = new ClassPathXmlApplicationContext("applicationContextConfig.xml");
		
		BlogCommentDAO blogCommentDAO = factory.getBean(BlogCommentDAO.class);
		
		BlogDAO blogDAO = factory.getBean(BlogDAO.class);
		UserDetailsDAO userDetailsDAO = factory.getBean(UserDetailsDAO.class);
		
		Blog blog = blogDAO.get(3);
		BlogComment blogComment = new BlogComment();
		DateTime dt = new DateTime();
		
		
		blogComment.setBlog_comment("Welcome to HIVE! Great to have you on board.");
		blogComment.setBlog_id(blog);
		blogComment.setUser_id(userDetailsDAO.get("phill"));
		blogComment.setCmnt_date_time(dt);
		blogCommentDAO.saveOrUpdate(blogComment);
	
		/*blogCommentDAO.delete(22);*/
		
		/*BlogComment blogComment = blogCommentDAO.get(5);
		System.out.println("BlogComment:-"+ blogComment.getBlog_name());
		System.out.println("BlogComment list size:-"+ blogCommentDAO.list().size());
		UserDetails user = blogComment.getBlogger();
		System.out.println("Blogger:" + user.getFirst_name());*/
		
		
		factory.close();

	}

}
