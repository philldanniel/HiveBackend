package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.UserRole;

@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements UserRoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public UserRoleDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public UserRoleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<UserRole> list(){
		@SuppressWarnings("unchecked")
		List<UserRole> listUserRole = sessionFactory.getCurrentSession().createCriteria(UserRole.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUserRole;
	}
	
	@Transactional
	public UserRole get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from UserRole where id=?");
		query.setInteger(0, id);
		
		UserRole userRole = (UserRole) query.uniqueResult();
		return userRole;
	}
	
	@Transactional
	public void saveOrUpdate(UserRole userRole) {
		getSessionFactory().getCurrentSession().saveOrUpdate(userRole);

	}
	
	@Transactional
	public void delete(int id) {
		UserRole userRole = new UserRole();
		userRole.setId(id);
		
		getSessionFactory().getCurrentSession().delete(userRole);

	}

}
