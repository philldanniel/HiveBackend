package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Blog;
import com.collab.hive.model.UserDetails;

@Repository("BlogDAO")
public class BlogDAOImpl implements BlogDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public BlogDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public BlogDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<Blog> list(){
		/*@SuppressWarnings("unchecked")
		List<Blog> listBlog = sessionFactory.getCurrentSession().createCriteria(Blog.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listBlog;*/
		
		Session session = sessionFactory.getCurrentSession();
		List<Blog> listBlog = session.createQuery("from Blog").list();
		return listBlog;
	}
	
	@Transactional
	public Blog get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Blog where blog_id=?");
		query.setInteger(0, id);
		
		Blog blog = (Blog) query.uniqueResult();
		return blog;
	}
	
	@Transactional
	public void saveOrUpdate(Blog blog) {
		getSessionFactory().getCurrentSession().saveOrUpdate(blog);

	}
	
	@Transactional
	public void delete(int id) {
		Blog blog = new Blog();
		blog.setBlog_id(id);
		
		getSessionFactory().getCurrentSession().delete(blog);

	}

}
