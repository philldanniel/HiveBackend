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

import com.collab.hive.dao.BlogCommentDAO;
import com.collab.hive.dao.BlogDAO;
import com.collab.hive.dao.UserDetailsDAO;
import com.collab.hive.model.BlogComment;
@RestController
public class BlogCommentRestController {
	@Autowired
	private BlogComment comment;
	
	@Autowired
	private BlogCommentDAO commentDAO;
	
	@Autowired
	private UserDetailsDAO userDAO;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@RequestMapping(value = "/comment/allComments/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<BlogComment>> getBlogComments(@PathVariable("id") int id){
		List <BlogComment> commentList = commentDAO.list(id);
		if(commentList.isEmpty()){
			return new ResponseEntity<List<BlogComment>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BlogComment>>(commentList, HttpStatus.OK);
	}
	
	@GetMapping("/comment/{id}")
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("id") int id){
		comment = commentDAO.get(id);
		if(comment == null){
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BlogComment>(comment, HttpStatus.OK);
	}
	
	@PostMapping("/comment/{bid}/{uid}")
	public ResponseEntity<BlogComment> createBlogComment(@RequestBody BlogComment newcomment,
			@PathVariable("bid") int blogId,@PathVariable("uid") String userId){
		newcomment.setUser_id(userDAO.get(userId));
		newcomment.setBlog_id(blogDAO.get(blogId));
		DateTime dt = new DateTime();
		newcomment.setCmnt_date_time(dt);
		commentDAO.saveOrUpdate(newcomment);
		return new ResponseEntity<BlogComment>(newcomment , HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/{id}")
	public ResponseEntity<BlogComment> deleteBlogComment(@PathVariable("id") int id){
		if(commentDAO.get(id) == null){
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
		}
		commentDAO.delete(id);
		return new ResponseEntity<BlogComment>(HttpStatus.OK);
	}
	
	/*@PutMapping("/comment/{id}")
	public ResponseEntity<BlogComment> updateBlogComment(@PathVariable("id") int id, @RequestBody BlogComment comment){
		if(commentDAO.get(id) == null){
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_FOUND);
		}
		commentDAO.saveOrUpdate(comment);
		return new ResponseEntity<BlogComment>(comment, HttpStatus.OK);
	}*/
	
}
