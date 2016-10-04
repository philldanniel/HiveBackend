package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.UserRole;

public interface UserRoleDAO {
	
	public List<UserRole> list();
	public UserRole get(int id);
	public void saveOrUpdate(UserRole userRole);
	public void delete(int id);
}
