package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.BlogComment;


@Repository("BlogCommentDAO")
public class BlogCommentDAOImpl implements BlogCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public BlogCommentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public BlogCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Transactional
	public List<BlogComment> list(int id){
		@SuppressWarnings("unchecked")
		String hql = "from BlogComment where blog_id='"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BlogComment> listBlogComment = query.list();
		/*List<BlogComment> listBlogComment = sessionFactory.getCurrentSession().createCriteria(BlogComment.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
		return listBlogComment;
	}
	
	@Transactional
	public BlogComment get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from BlogComment where blog_id=?");
		query.setInteger(0, id);
		
		BlogComment blogComment = (BlogComment) query.uniqueResult();
		return blogComment;
	}
	
	@Transactional
	public void saveOrUpdate(BlogComment blogComment) {
		getSessionFactory().getCurrentSession().saveOrUpdate(blogComment);

	}
	
	@Transactional
	public void delete(int id) {
		BlogComment blogComment = new BlogComment();
		blogComment.setComment_id(id);;
		
		getSessionFactory().getCurrentSession().delete(blogComment);

	}

}
