package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Role;

public interface RoleDAO {
	
	public List<Role> list();
	public Role get(int id);
	public void saveOrUpdate(Role role);
	public void delete(int id);
}
