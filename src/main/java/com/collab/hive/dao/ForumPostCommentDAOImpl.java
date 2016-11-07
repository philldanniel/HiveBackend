package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.ForumPostComment;

@Repository("ForumPostCommentDAO")
public class ForumPostCommentDAOImpl implements ForumPostCommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ForumPostCommentDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
/*
	@Autowired
	public ForumPostCommentDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<ForumPostComment> list(int id){
		@SuppressWarnings("unchecked")
		String hql = "from ForumPostComment where post_id='"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<ForumPostComment> listForumPostComment = query.list();
		return listForumPostComment;
	}
	
	@Transactional
	public ForumPostComment get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumPostComment where comment_id=?");
		query.setInteger(0, id);
		
		ForumPostComment forumPostComment = (ForumPostComment) query.uniqueResult();
		return forumPostComment;
	}
	
	@Transactional
	public void saveOrUpdate(ForumPostComment forumPostComment) {
		getSessionFactory().getCurrentSession().saveOrUpdate(forumPostComment);

	}
	
	@Transactional
	public void delete(int id) {
		ForumPostComment forumPostComment = new ForumPostComment();
		forumPostComment.setComment_id(id);
		
		getSessionFactory().getCurrentSession().delete(forumPostComment);

	}

}
