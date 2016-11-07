package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.ForumPost;

public interface ForumPostDAO {
	
	public List<ForumPost> list(int id);
	public List<ForumPost> approvedPostlist(int id);
	public List<ForumPost> pendingPostlist(int id);
	public ForumPost get(int id);
	public void saveOrUpdate(ForumPost forumPost);
	public void delete(int id);
}
