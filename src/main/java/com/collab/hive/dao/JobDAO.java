package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Job;

public interface JobDAO {
	
	public List<Job> list();
	public Job get(int id);
	public void saveOrUpdate(Job job);
	public void delete(int id);
}
