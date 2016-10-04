package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Forum;

public interface ForumDAO {
	
	public List<Forum> list();
	public Forum get(int id);
	public void saveOrUpdate(Forum forum);
	public void delete(int id);
}
