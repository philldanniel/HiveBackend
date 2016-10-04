package com.collab.hive.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.collab.hive.model.Article;

@Repository("ArticleDAO")
public class ArticleDAOImpl implements ArticleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ArticleDAOImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	@Autowired
	public ArticleDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	*/
	
	
	@Transactional
	public List<Article> list(){
		@SuppressWarnings("unchecked")
		List<Article> listArticle = sessionFactory.getCurrentSession().createCriteria(Article.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listArticle;
	}
	
	@Transactional
	public Article get(int id) {
		Session session=getSessionFactory().getCurrentSession();
		Query query =session.createQuery("from Article where article_id=?");
		query.setInteger(0, id);
		
		Article article = (Article) query.uniqueResult();
		return article;
	}
	
	@Transactional
	public void saveOrUpdate(Article article) {
		getSessionFactory().getCurrentSession().saveOrUpdate(article);

	}
	
	@Transactional
	public void delete(int id) {
		Article article = new Article();
		article.setArticle_id(id);
		
		getSessionFactory().getCurrentSession().delete(article);

	}

}
