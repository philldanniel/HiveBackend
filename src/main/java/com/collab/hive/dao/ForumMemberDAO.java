package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.ForumMember;

public interface ForumMemberDAO {
	
	public List<ForumMember> list();
	public ForumMember get(int id);
	public void saveOrUpdate(ForumMember forumMember);
	public void delete(int id);
}
