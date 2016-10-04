package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.BlogComment;

public interface BlogCommentDAO {
	
	public List<BlogComment> list();
	public BlogComment get(int id);
	public void saveOrUpdate(BlogComment blogComment);
	public void delete(int id);
}
