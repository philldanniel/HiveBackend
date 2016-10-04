package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Blog;

public interface BlogDAO {
	
	public List<Blog> list();
	public Blog get(int id);
	public void saveOrUpdate(Blog blog);
	public void delete(int id);
}
