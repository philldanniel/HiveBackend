package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.UserDetails;

@Repository("UserDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public UserDetailsDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public UserUserDetailsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<UserDetails> list(){
		@SuppressWarnings("unchecked")
		List<UserDetails> listUserDetails = sessionFactory.getCurrentSession().createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserDetails;
	}
	
	@Transactional
	public UserDetails get(String id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from UserDetails where user_id=?");
		query.setString(0, id);
		
		UserDetails userDetails = (UserDetails) query.uniqueResult();
		return userDetails;
	}
	
	@Transactional
	public void saveOrUpdate(UserDetails userDetails) {
		getSessionFactory().getCurrentSession().saveOrUpdate(userDetails);

	}
	
	@Transactional
	public void delete(String id) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUser_id(id);;
		
		getSessionFactory().getCurrentSession().delete(userDetails);

	}
	
	@Transactional
	public boolean isValidUser(String id,String password) {
		String hql = "from UserDetails where user_id='" + id + "' and password='"+ password +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("deprecation")
		List listUser = query.list();
		if (listUser != null && !listUser.isEmpty()) {
			return true;
		}
		else{
			return false;
		}
	}


}
