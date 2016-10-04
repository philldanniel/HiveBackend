package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.ForumMember;

@Repository("ForumMemberDAO")
public class ForumMemberDAOImpl implements ForumMemberDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ForumMemberDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public ForumMemberDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<ForumMember> list(){
		@SuppressWarnings("unchecked")
		List<ForumMember> listForumMember = sessionFactory.getCurrentSession().createCriteria(ForumMember.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listForumMember;
	}
	
	@Transactional
	public ForumMember get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from ForumMember where id=?");
		query.setInteger(0, id);
		
		ForumMember forumMember = (ForumMember) query.uniqueResult();
		return forumMember;
	}
	
	@Transactional
	public void saveOrUpdate(ForumMember forumMember) {
		getSessionFactory().getCurrentSession().saveOrUpdate(forumMember);

	}
	
	@Transactional
	public void delete(int id) {
		ForumMember forumMember = new ForumMember();
		forumMember.setId(id);
		
		getSessionFactory().getCurrentSession().delete(forumMember);

	}

}
