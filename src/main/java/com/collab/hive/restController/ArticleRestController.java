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

import com.collab.hive.dao.ArticleDAO;
import com.collab.hive.model.Article;
@RestController
public class ArticleRestController {
	@Autowired
	private Article article;
	
	@Autowired
	private ArticleDAO articleDAO;
	
	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public ResponseEntity<List<Article>> getArticles(){
		List <Article> articleList = articleDAO.list();
		if(articleList.isEmpty()){
			return new ResponseEntity<List<Article>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Article>>(articleList, HttpStatus.OK);
	}
	
	@GetMapping("/articles/{id}")
	public ResponseEntity<Article> getArticle(@PathVariable("id") int id){
		article = articleDAO.get(id);
		if(article == null){
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
	@PostMapping("/article")
	public ResponseEntity<Article> createArticle(@RequestBody Article newarticle){
		articleDAO.saveOrUpdate(newarticle);
		return new ResponseEntity<Article>(newarticle , HttpStatus.OK);
	}
	
	@DeleteMapping("/article/{id}")
	public ResponseEntity<Article> deleteArticle(@PathVariable("id") int id){
		if(articleDAO.get(id) == null){
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
		articleDAO.delete(id);
		return new ResponseEntity<Article>(HttpStatus.OK);
	}
	
	@PutMapping("/article/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable("id") int id, @RequestBody Article article){
		if(articleDAO.get(id) == null){
			return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
		}
		articleDAO.saveOrUpdate(article);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
	
}
