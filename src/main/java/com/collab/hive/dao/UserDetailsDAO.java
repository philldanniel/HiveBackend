package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.UserDetails;

public interface UserDetailsDAO {
	
	public List<UserDetails> list();
	public UserDetails get(String id);
	public void saveOrUpdate(UserDetails userDetails);
	public void delete(String id);
	public boolean isValidUser(String id,String password);
}
