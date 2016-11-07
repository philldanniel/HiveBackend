package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.ForumPost;

@Repository("ForumPostDAO")
public class ForumPostDAOImpl implements ForumPostDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ForumPostDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public ForumPostDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<ForumPost> list(int id){
		@SuppressWarnings("unchecked")
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumPost where forum_id=?");
		query.setInteger(0, id);
		
		List<ForumPost> listForumPost = query.list();
		return listForumPost;
	}
	
	@Transactional
	public List<ForumPost> approvedPostlist(int id){
		@SuppressWarnings("unchecked")
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumPost where forum_id=? and status='1'");
		query.setInteger(0, id);
		
		List<ForumPost> listForumPost = query.list();
		return listForumPost;
	}
	
	@Transactional
	public List<ForumPost> pendingPostlist(int id){
		@SuppressWarnings("unchecked")
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumPost where forum_id=? and status='0'");
		query.setInteger(0, id);
		
		List<ForumPost> listForumPost = query.list();
		return listForumPost;
	}
	
	@Transactional
	public ForumPost get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumPost where post_id=?");
		query.setInteger(0, id);
		
		ForumPost forumPost = (ForumPost) query.uniqueResult();
		return forumPost;
	}
	
	@Transactional
	public void saveOrUpdate(ForumPost forumPost) {
		getSessionFactory().getCurrentSession().saveOrUpdate(forumPost);

	}
	
	@Transactional
	public void delete(int id) {
		ForumPost forumPost = new ForumPost();
		forumPost.setPost_id(id);
		
		getSessionFactory().getCurrentSession().delete(forumPost);

	}

}
