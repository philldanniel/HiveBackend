package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Job;

@Repository("JobDAO")
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public JobDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public JobDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<Job> list(){
		@SuppressWarnings("unchecked")
		List<Job> listJob = sessionFactory.getCurrentSession().createCriteria(Job.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listJob;
	}
	
	@Transactional
	public Job get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Job where job_id=?");
		query.setInteger(0, id);
		
		Job job = (Job) query.uniqueResult();
		return job;
	}
	
	@Transactional
	public void saveOrUpdate(Job job) {
		getSessionFactory().getCurrentSession().saveOrUpdate(job);

	}
	
	@Transactional
	public void delete(int id) {
		Job job = new Job();
		job.setJob_id(id);
		
		getSessionFactory().getCurrentSession().delete(job);

	}

}
