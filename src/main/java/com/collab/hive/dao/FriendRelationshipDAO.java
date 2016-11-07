package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.FriendRelationship;

public interface FriendRelationshipDAO {
	
	public List<FriendRelationship> list(String id);
	public List<FriendRelationship> listPending(String id);
	public List<FriendRelationship> listAccepted(String id);
	public List<FriendRelationship> listRejected(String id);
	public FriendRelationship get(int id);
	public void saveOrUpdate(FriendRelationship friend);
	public void delete(int id);
}
