package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.ForumPostComment;

public interface ForumPostCommentDAO {
	
	public List<ForumPostComment> list();
	public ForumPostComment get(int id);
	public void saveOrUpdate(ForumPostComment forumPostComment);
	public void delete(int id);
}
