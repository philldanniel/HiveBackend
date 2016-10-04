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
		
		Blog blog = blogDAO.get(2);
		BlogComment blogComment = new BlogComment();
		DateTime dt = new DateTime();
		
		
		blogComment.setBlog_comment("Hey there, welcome to HIVE! Great to have you on board.");
		blogComment.setBlog_id(blog);
		blogComment.setUser_id(blog.getBlogger());
		blogComment.setCmnt_date_time(dt);
		blogCommentDAO.saveOrUpdate(blogComment);
		
		/*blogCommentDAO.delete(1);*/
		
		/*BlogComment blogComment = blogCommentDAO.get(5);
		System.out.println("BlogComment:-"+ blogComment.getBlog_name());
		System.out.println("BlogComment list size:-"+ blogCommentDAO.list().size());
		UserDetails user = blogComment.getBlogger();
		System.out.println("Blogger:" + user.getFirst_name());*/
		
		
		factory.close();

	}

}
