package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Event;

public interface EventDAO {
	
	public List<Event> list();
	public Event get(int id);
	public void saveOrUpdate(Event event);
	public void delete(int id);
}
