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

import com.collab.hive.dao.FriendRelationshipDAO;
import com.collab.hive.model.FriendRelationship;
@RestController
public class FriendRestController {
	@Autowired
	private FriendRelationship friend;
	
	@Autowired
	private FriendRelationshipDAO friendDAO;
	
	@GetMapping("/friends/{id}")
	public ResponseEntity<List<FriendRelationship>> getAllFriends(@PathVariable("id") String id){
		List <FriendRelationship> friendList = friendDAO.list(id);
		if(friendList.isEmpty()){
			return new ResponseEntity<List<FriendRelationship>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FriendRelationship>>(friendList, HttpStatus.OK);
	}
	
	@GetMapping("/friends/pending/{id}")
	public ResponseEntity<List<FriendRelationship>> getAllPendingReqs(@PathVariable("id") String id){
		List <FriendRelationship> friendList = friendDAO.listPending(id);
		if(friendList.isEmpty()){
			return new ResponseEntity<List<FriendRelationship>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FriendRelationship>>(friendList, HttpStatus.OK);
	}
	
	@GetMapping("/friends/accepted/{id}")
	public ResponseEntity<List<FriendRelationship>> getAllAcceptedReqs(@PathVariable("id") String id){
		List <FriendRelationship> friendList = friendDAO.listAccepted(id);
		if(friendList.isEmpty()){
			return new ResponseEntity<List<FriendRelationship>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FriendRelationship>>(friendList, HttpStatus.OK);
	}
	
	@GetMapping("/friends/rejected/{id}")
	public ResponseEntity<List<FriendRelationship>> getAllRejectedReqs(@PathVariable("id") String id){
		List <FriendRelationship> friendList = friendDAO.listRejected(id);
		if(friendList.isEmpty()){
			return new ResponseEntity<List<FriendRelationship>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FriendRelationship>>(friendList, HttpStatus.OK);
	}
	
	@PostMapping("/friends")
	public ResponseEntity<FriendRelationship> createFriendRelationship(@RequestBody FriendRelationship newfriend){
		newfriend.setStatus(0);
		friendDAO.saveOrUpdate(newfriend);
		return new ResponseEntity<FriendRelationship>(newfriend , HttpStatus.OK);
	}
	
	@PostMapping("/friends/accept/{fid}")
	public ResponseEntity<FriendRelationship> accept(@PathVariable("fid") int fid){
		friend = friendDAO.get(fid);
		friend.setStatus(1);
		friendDAO.saveOrUpdate(friend);
		return new ResponseEntity<FriendRelationship>(friend , HttpStatus.OK);
	}
	
	@PostMapping("/friends/reject/{fid}")
	public ResponseEntity<FriendRelationship> reject(@PathVariable("fid") int fid){
		friend = friendDAO.get(fid);
		friend.setStatus(2);
		friendDAO.saveOrUpdate(friend);
		return new ResponseEntity<FriendRelationship>(friend , HttpStatus.OK);
	}
	
	@DeleteMapping("/friends/{id}")
	public ResponseEntity<FriendRelationship> deleteFriendRelationship(@PathVariable("id") int id){
		if(friendDAO.get(id) == null){
			return new ResponseEntity<FriendRelationship>(HttpStatus.NOT_FOUND);
		}
		friendDAO.delete(id);
		return new ResponseEntity<FriendRelationship>(HttpStatus.OK);
	}
	
	@PutMapping("/friends/{id}")
	public ResponseEntity<FriendRelationship> updateFriendRelationship(@PathVariable("id") int id, @RequestBody FriendRelationship friend){
		if(friendDAO.get(id) == null){
			return new ResponseEntity<FriendRelationship>(HttpStatus.NOT_FOUND);
		}
		friendDAO.saveOrUpdate(friend);
		return new ResponseEntity<FriendRelationship>(friend, HttpStatus.OK);
	}
	
}
