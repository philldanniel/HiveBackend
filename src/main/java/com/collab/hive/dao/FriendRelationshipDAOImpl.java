package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.FriendRelationship;

@Repository("FriendRelationshipDAO")
public class FriendRelationshipDAOImpl implements FriendRelationshipDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public FriendRelationshipDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public FriendRelationshipDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<FriendRelationship> list(String id){
		@SuppressWarnings("unchecked")
		/*List<FriendRelationship> listFriendRelationship = sessionFactory.getCurrentSession().createCriteria(FriendRelationship.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
		
		Query query = sessionFactory.getCurrentSession().createQuery("from FriendRelationship where (user_id_one=? or user_id_two=?)");
		query.setString(0, id);
		query.setString(1, id);
		List<FriendRelationship> listFriend = query.list(); 
		return listFriend;
	}
	
	@Transactional
	public List<FriendRelationship> listPending(String id){
		@SuppressWarnings("unchecked")
		/*List<FriendRelationship> listFriendRelationship = sessionFactory.getCurrentSession().createCriteria(FriendRelationship.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
		
		Query query = sessionFactory.getCurrentSession().createQuery("from FriendRelationship where (user_id_one=? or user_id_two=?) and status='0'");
		query.setString(0, id);
		query.setString(1, id);
		List<FriendRelationship> listFriend = query.list(); 
		return listFriend;
	}
	
	@Transactional
	public List<FriendRelationship> listAccepted(String id){
		@SuppressWarnings("unchecked")
		/*List<FriendRelationship> listFriendRelationship = sessionFactory.getCurrentSession().createCriteria(FriendRelationship.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
		
		Query query = sessionFactory.getCurrentSession().createQuery("from FriendRelationship where (user_id_one=? or user_id_two=?) and status='1'");
		query.setString(0, id);
		query.setString(1, id);
		List<FriendRelationship> listFriend = query.list(); 
		return listFriend;
	}
	
	@Transactional
	public List<FriendRelationship> listRejected(String id){
		@SuppressWarnings("unchecked")
		/*List<FriendRelationship> listFriendRelationship = sessionFactory.getCurrentSession().createCriteria(FriendRelationship.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();*/
		
		Query query = sessionFactory.getCurrentSession().createQuery("from FriendRelationship where (user_id_one=? or user_id_two=?) and status='2'");
		query.setString(0, id);
		query.setString(1, id);
		List<FriendRelationship> listFriend = query.list(); 
		return listFriend;
	}
	
	@Transactional
	public FriendRelationship get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from FriendRelationship where id=?");
		query.setInteger(0, id);
		
		FriendRelationship friend = (FriendRelationship) query.uniqueResult();
		return friend;
	}
	
	@Transactional
	public void saveOrUpdate(FriendRelationship friend) {
		getSessionFactory().getCurrentSession().saveOrUpdate(friend);

	}
	
	@Transactional
	public void delete(int id) {
		FriendRelationship friend = new FriendRelationship();
		friend.setId(id);
		
		getSessionFactory().getCurrentSession().delete(friend);

	}

}
