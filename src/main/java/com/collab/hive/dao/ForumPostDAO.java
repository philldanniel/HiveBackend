package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.ForumPost;

public interface ForumPostDAO {
	
	public List<ForumPost> list();
	public List<ForumPost> approvedPostlist();
	public ForumPost get(int id);
	public void saveOrUpdate(ForumPost forumPost);
	public void delete(int id);
}
