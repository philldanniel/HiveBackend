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

import com.collab.hive.dao.BlogDAO;
import com.collab.hive.model.Blog;
@RestController
public class BlogRestController {
	@Autowired
	private Blog blog;
	
	@Autowired
	private BlogDAO blogDAO;
	
	@RequestMapping(value = "/blogs", method = RequestMethod.GET)
	public ResponseEntity<List<Blog>> getBlogs(){
		List <Blog> blogList = blogDAO.list();
		if(blogList.isEmpty()){
			return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Blog>>(blogList, HttpStatus.OK);
	}
	
	@GetMapping("/blogs/{id}")
	public ResponseEntity<Blog> getBlog(@PathVariable("id") int id){
		blog = blogDAO.get(id);
		if(blog == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
	@PostMapping("/blogs")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog newblog){
		blogDAO.saveOrUpdate(newblog);
		return new ResponseEntity<Blog>(newblog , HttpStatus.OK);
	}
	
	@DeleteMapping("/blogs/{id}")
	public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id){
		if(blogDAO.get(id) == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.delete(id);
		return new ResponseEntity<Blog>(HttpStatus.OK);
	}
	
	@PutMapping("/blogs/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id, @RequestBody Blog blog){
		if(blogDAO.get(id) == null){
			return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
		}
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog, HttpStatus.OK);
	}
	
}
