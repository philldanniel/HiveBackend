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

import com.collab.hive.dao.RoleDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.dao.UserRoleDAO;
import com.collab.hive.model.Role;
import com.collab.hive.model.UserDetails;
import com.collab.hive.model.UserRole;
@RestController
public class UserDetailsRestController {
	@Autowired
	private UserDetails user;
	
	@Autowired
	private UserDetailsDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired
	private UserRole userRole;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> getUserDetailss(){
		List <UserDetails> userList = userDAO.list();
		if(userList.isEmpty()){
			return new ResponseEntity<List<UserDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserDetails>>(userList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/role", method = RequestMethod.GET)
	public ResponseEntity<List<Role>> getRole(){
		List <Role> roleList = roleDAO.list();
		if(roleList.isEmpty()){
			return new ResponseEntity<List<Role>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Role>>(roleList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/userRole", method = RequestMethod.GET)
	public ResponseEntity<List<UserRole>> getUserRole(){
		List <UserRole> userRoleList = userRoleDAO.list();
		if(userRoleList.isEmpty()){
			return new ResponseEntity<List<UserRole>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<UserRole>>(userRoleList, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<UserDetails> getUserDetails(@PathVariable("id") String id){
		user = userDAO.get(id);
		if(user == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
	
	@PostMapping("/users/role/{role}")
	public ResponseEntity<UserDetails> createUserDetails(@RequestBody UserDetails newuser, @PathVariable("role") String roleName){
		userDAO.saveOrUpdate(newuser);
		Role role = roleDAO.getRoleByName(roleName);
		userRole.setRole(role);
		userRole.setUserDetails(newuser);
		userRoleDAO.saveOrUpdate(userRole);
		return new ResponseEntity<UserDetails>(newuser , HttpStatus.OK);
	}
	
	@PostMapping("/users/authenticateCurrentUser/{id}")
	public ResponseEntity<String> authenticateCurrentUser(@PathVariable("id") String userId, 
			@RequestBody String password){
		userDAO.isValidUser(userId, password);
		String loggedIn = Boolean.toString(userDAO.isValidUser(userId, password));
		return new ResponseEntity<String>(loggedIn, HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<UserDetails> deleteUserDetails(@PathVariable("id") String id){
		if(userDAO.get(id) == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		userDAO.delete(id);
		return new ResponseEntity<UserDetails>(HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<UserDetails> updateUserDetails(@PathVariable("id") String id, @RequestBody UserDetails user){
		if(userDAO.get(id) == null){
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		userDAO.saveOrUpdate(user);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}
}
