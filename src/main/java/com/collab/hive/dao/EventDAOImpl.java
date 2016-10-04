package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Event;

@Repository("EventDAO")
public class EventDAOImpl implements EventDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public EventDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public EventDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<Event> list(){
		@SuppressWarnings("unchecked")
		List<Event> listEvent = sessionFactory.getCurrentSession().createCriteria(Event.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listEvent;
	}
	
	@Transactional
	public Event get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Event where event_id=?");
		query.setInteger(0, id);
		
		Event event = (Event) query.uniqueResult();
		return event;
	}
	
	@Transactional
	public void saveOrUpdate(Event event) {
		getSessionFactory().getCurrentSession().saveOrUpdate(event);

	}
	
	@Transactional
	public void delete(int id) {
		Event event = new Event();
		event.setEvent_id(id);
		
		getSessionFactory().getCurrentSession().delete(event);

	}

}
