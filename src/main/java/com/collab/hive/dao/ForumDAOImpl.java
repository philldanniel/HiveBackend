package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Forum;

@Repository("ForumDAO")
public class ForumDAOImpl implements ForumDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ForumDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public ForumDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<Forum> list(){
		@SuppressWarnings("unchecked")
		List<Forum> listForum = sessionFactory.getCurrentSession().createCriteria(Forum.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listForum;
	}
	
	@Transactional
	public List<Forum> approvedList(){
		@SuppressWarnings("unchecked")
		List<Forum> listForum = sessionFactory.getCurrentSession().createQuery("from Forum where status='1'").list();
		return listForum;
	}
	
	@Transactional
	public List<Forum> pendingList(){
		@SuppressWarnings("unchecked")
		List<Forum> listForum = sessionFactory.getCurrentSession().createQuery("from Forum where status='0'").list();
		return listForum;
	}
	
	@Transactional
	public Forum get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Forum where forum_id=?");
		query.setInteger(0, id);
		
		Forum forum = (Forum) query.uniqueResult();
		return forum;
	}
	
	@Transactional
	public void saveOrUpdate(Forum forum) {
		getSessionFactory().getCurrentSession().saveOrUpdate(forum);

	}
	
	@Transactional
	public void delete(int id) {
		Forum forum = new Forum();
		forum.setForum_id(id);
		
		getSessionFactory().getCurrentSession().delete(forum);

	}

}
