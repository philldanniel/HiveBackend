package com.collab.hive.restController;

import java.util.List;

import org.joda.time.DateTime;
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

import com.collab.hive.dao.ForumDAO;
import com.collab.hive.dao.ForumPostCommentDAO;
import com.collab.hive.dao.ForumPostDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.Forum;
import com.collab.hive.model.ForumPost;
import com.collab.hive.model.ForumPostComment;
import com.collab.hive.model.UserDetails;
@RestController
public class ForumRestController {
	@Autowired
	private Forum forum;
	
	@Autowired
	private ForumDAO forumDAO;
	
	@Autowired
	private ForumPost forumPost;
	
	@Autowired
	private ForumPostDAO forumPostDAO;
	
	@Autowired
	private ForumPostComment forumPostComment;
	
	@Autowired
	private ForumPostCommentDAO forumPostCommentDAO;
	
	@Autowired
	private UserDetails user;
	
	@Autowired
	private UserDetailsDAO userDAO;
	
	/*@RequestMapping(value = "/forums", method = RequestMethod.GET)*/
	@GetMapping(value= "/forums", produces="application/json; charset=UTF-8" )
	public ResponseEntity<List<Forum>> getForums(){
		List<Forum> forumList = forumDAO.list();
		if(forumList.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(forumList, HttpStatus.OK);
	}
	
	@GetMapping(value= "/forums/approved", produces="application/json; charset=UTF-8" )
	public ResponseEntity<List<Forum>> getApprovedForums(){
		List<Forum> forumList = forumDAO.approvedList();
		if(forumList.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(forumList, HttpStatus.OK);
	}
	
	@GetMapping(value= "/forums/pending", produces="application/json; charset=UTF-8" )
	public ResponseEntity<List<Forum>> getPendingForums(){
		List<Forum> forumList = forumDAO.pendingList();
		if(forumList.isEmpty()){
			return new ResponseEntity<List<Forum>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Forum>>(forumList, HttpStatus.OK);
	}
	
	@GetMapping("/forums/{id}")
	public ResponseEntity<Forum> getForum(@PathVariable("id") int id){
		forum = forumDAO.get(id);
		if(forum == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		
	}
	
	@PostMapping("/forums/{id}")
	public ResponseEntity<Forum> createForum(@RequestBody Forum newforum, @PathVariable("id") String userId){
		user = userDAO.get(userId);
		newforum.setForum_creator(user);
		DateTime dt = new DateTime();
		newforum.setForum_date(dt);
		
		forumDAO.saveOrUpdate(newforum);
		return new ResponseEntity<Forum>(newforum , HttpStatus.OK);
	}
	
	@PostMapping("/forums/approve/{id}")
	public ResponseEntity<Forum> approveForum(@PathVariable("id") int fId){
		forum = forumDAO.get(fId);
		forum.setStatus(1);
		forumDAO.saveOrUpdate(forum);
		return new ResponseEntity<Forum>(forum , HttpStatus.OK);
	}
	
	@PostMapping("/forums/reject/{id}")
	public ResponseEntity<Forum> rejectForum(@PathVariable("id") int fId){
		forum = forumDAO.get(fId);
		forum.setStatus(2);
		forumDAO.saveOrUpdate(forum);
		return new ResponseEntity<Forum>(forum , HttpStatus.OK);
	}
	
	@DeleteMapping("/forums/{id}")
	public ResponseEntity<Forum> deleteForum(@PathVariable("id") int id){
		if(forumDAO.get(id) == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forumDAO.delete(id);
		return new ResponseEntity<Forum>(HttpStatus.OK);
	}
	
	@PutMapping("/forums/{id}")
	public ResponseEntity<Forum> updateForum(@PathVariable("id") int id, @RequestBody Forum forum){
		if(forumDAO.get(id) == null){
			return new ResponseEntity<Forum>(HttpStatus.NOT_FOUND);
		}
		forumDAO.saveOrUpdate(forum);
		return new ResponseEntity<Forum>(forum, HttpStatus.OK);
	}
	/*-------------------------------------------End of Forum----------------------------------------*/
	
	/*-----------------------------------------Start of Forum-Post---------------------------------------*/
	
	@GetMapping(value= "/forumPost", produces="application/json; charset=UTF-8" )
	public ResponseEntity<List<ForumPost>> getForumPosts(){
		List<ForumPost> forumPostList = forumPostDAO.list();
		if(forumPostList.isEmpty()){
			return new ResponseEntity<List<ForumPost>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ForumPost>>(forumPostList, HttpStatus.OK);
	}
	
	@GetMapping("/forumPost/{id}")
	public ResponseEntity<ForumPost> getForumPost(@PathVariable("id") int id){
		forumPost = forumPostDAO.get(id);
		if(forumPost == null){
			return new ResponseEntity<ForumPost>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumPost>(forumPost, HttpStatus.OK);
		
	}
	
	@PostMapping("/forumPost/{id}")
	public ResponseEntity<ForumPost> createForumPost(@RequestBody ForumPost newPost, @PathVariable("id") String userId){
		user = userDAO.get(userId);
		newPost.setPost_creator(user);
		DateTime dt = new DateTime();
		newPost.setPost_date(dt);
		
		forumPostDAO.saveOrUpdate(newPost);
		return new ResponseEntity<ForumPost>(newPost , HttpStatus.OK);
	}
	
	@DeleteMapping("/forumPost/{id}")
	public ResponseEntity<ForumPost> deleteForumPost(@PathVariable("id") int id){
		if(forumPostDAO.get(id) == null){
			return new ResponseEntity<ForumPost>(HttpStatus.NOT_FOUND);
		}
		forumPostDAO.delete(id);
		return new ResponseEntity<ForumPost>(HttpStatus.OK);
	}
	
	@PutMapping("/forumPost/{id}")
	public ResponseEntity<ForumPost> updateForumPost(@PathVariable("id") int id, @RequestBody ForumPost forumPost){
		if(forumPostDAO.get(id) == null){
			return new ResponseEntity<ForumPost>(HttpStatus.NOT_FOUND);
		}
		forumPostDAO.saveOrUpdate(forumPost);
		return new ResponseEntity<ForumPost>(forumPost, HttpStatus.OK);
	}
	
	/*-----------------------------------------End Forum-Post---------------------------------------*/
	
	
	/*-------------------------------------Start of Forum-Post-Comment---------------------------------------*/
	
	@GetMapping(value= "/forumPostComment", produces="application/json; charset=UTF-8" )
	public ResponseEntity<List<ForumPostComment>> getForumPostComments(){
		List<ForumPostComment> forumPostCommentList = forumPostCommentDAO.list();
		if(forumPostCommentList.isEmpty()){
			return new ResponseEntity<List<ForumPostComment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ForumPostComment>>(forumPostCommentList, HttpStatus.OK);
	}
	
	@GetMapping("/forumPostComment/{id}")
	public ResponseEntity<ForumPostComment> getForumPostComment(@PathVariable("id") int id){
		forumPostComment = forumPostCommentDAO.get(id);
		if(forumPostComment == null){
			return new ResponseEntity<ForumPostComment>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ForumPostComment>(forumPostComment, HttpStatus.OK);
		
	}
	
	@PostMapping("/forumPostComment/{id}")
	public ResponseEntity<ForumPostComment> createForumPostComment(@RequestBody ForumPostComment newComment,
			@PathVariable("id") String userId){
		user = userDAO.get(userId);
		newComment.setMember(user);
		DateTime dt = new DateTime();
		newComment.setPostcmnt_date(dt);
		
		forumPostCommentDAO.saveOrUpdate(newComment);
		return new ResponseEntity<ForumPostComment>(newComment , HttpStatus.OK);
	}
	
	@DeleteMapping("/forumPostComment/{id}")
	public ResponseEntity<ForumPostComment> deleteForumPostComment(@PathVariable("id") int id){
		if(forumPostCommentDAO.get(id) == null){
			return new ResponseEntity<ForumPostComment>(HttpStatus.NOT_FOUND);
		}
		forumPostCommentDAO.delete(id);
		return new ResponseEntity<ForumPostComment>(HttpStatus.OK);
	}
	
	@PutMapping("/forumPostComment/{id}")
	public ResponseEntity<ForumPostComment> updateForumPostComment(@PathVariable("id") int id,
			@RequestBody ForumPostComment comment){
		if(forumPostCommentDAO.get(id) == null){
			return new ResponseEntity<ForumPostComment>(HttpStatus.NOT_FOUND);
		}
		forumPostCommentDAO.saveOrUpdate(comment);
		return new ResponseEntity<ForumPostComment>(comment, HttpStatus.OK);
	}
	
	/*---------------------------------------End of Forum-Post-Comment---------------------------------------*/
}
