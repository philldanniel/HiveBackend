package com.collab.hive.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.collab.hive.dao.EventDAO;
import com.collab.hive.model.Event;
@RestController
public class EventRestController {
	@Autowired
	private Event event;
	
	@Autowired
	private EventDAO eventDAO;
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public ResponseEntity<List<Event>> getEvents(){
		List <Event> eventList = eventDAO.list();
		if(eventList.isEmpty()){
			return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
	}
	
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable("id") int id){
		event = eventDAO.get(id);
		if(event == null){
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
	@PostMapping("/event")
	public ResponseEntity<Event> createEvent(@RequestBody Event newevent){
		eventDAO.saveOrUpdate(newevent);
		return new ResponseEntity<Event>(newevent , HttpStatus.OK);
	}
	
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable("id") int id){
		if(eventDAO.get(id) == null){
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
		eventDAO.delete(id);
		return new ResponseEntity<Event>(HttpStatus.OK);
	}
	
	@PutMapping("/event/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable("id") int id, @RequestBody Event event){
		if(eventDAO.get(id) == null){
			return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
		}
		eventDAO.saveOrUpdate(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}
	
}
