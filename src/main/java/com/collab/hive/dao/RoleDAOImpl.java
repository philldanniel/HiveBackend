package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Role;

@Repository("RoleDAO")
public class RoleDAOImpl implements RoleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public RoleDAOImpl() {
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
	public List<Role> list(){
		@SuppressWarnings("unchecked")
		List<Role> listRole = sessionFactory.getCurrentSession().createCriteria(Role.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listRole;
	}
	
	@Transactional
	public Role get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Role where role_id=?");
		query.setInteger(0, id);
		
		Role role = (Role) query.uniqueResult();
		return role;
	}
	
	@Transactional
	public void saveOrUpdate(Role role) {
		getSessionFactory().getCurrentSession().saveOrUpdate(role);

	}
	
	@Transactional
	public void delete(int id) {
		Role role = new Role();
		role.setRole_id(id);
		
		getSessionFactory().getCurrentSession().delete(role);

	}

}
