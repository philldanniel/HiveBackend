package com.collab.hive.dao;

import java.util.List;

import com.collab.hive.model.Article;

public interface ArticleDAO {
	
	public List<Article> list();
	public Article get(int id);
	public void saveOrUpdate(Article article);
	public void delete(int id);
}
