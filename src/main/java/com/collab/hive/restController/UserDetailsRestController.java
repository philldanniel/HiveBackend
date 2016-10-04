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

import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.UserDetails;
@RestController
public class UserDetailsRestController {
	@Autowired
	private UserDetails user;
	
	@Autowired
	private UserDetailsDAO userDAO;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUserDetailss(){
		List <UserDetails> userList = userDAO.list();
		if(userList.isEmpty()){
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetails>>(userList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable("id") String id){
		user = userDAO.get(id);
		if(user == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails newuser){
		userDAO.saveOrUpdate(newuser);
		return new ResponseEntity<UserDetails>(newuser , HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<UserDetails> deleteUserDetails(@PathVariable("id") String id){
		if(userDAO.get(id) == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		userDAO.delete(id);
		return new ResponseEntity<UserDetails>(HttpStatus.OK);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<UserDetails> updateUserDetails(@PathVariable("id") String id, @RequestBody UserDetails user){
		if(userDAO.get(id) == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
}
