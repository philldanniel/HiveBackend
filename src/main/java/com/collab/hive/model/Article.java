package com.collab.hive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="art_seq")
	@SequenceGenerator(
			name="art_seq",
			sequenceName="article_sequence",
			initialValue=1,
			allocationSize=1)
	private int article_id;
	@Column(length=100)
	private String article_name;
	@Column(length=1000)
	private String article;
	private String article_creator;
	/*@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	LocalDateTime article_date;*/
	private DateTime article_date;
	
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getArticle_name() {
		return article_name;
	}
	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getArticle_creator() {
		return article_creator;
	}
	public void setArticle_creator(String article_creator) {
		this.article_creator = article_creator;
	}
	public DateTime getArticle_date() {
		return article_date;
	}
	public void setArticle_date(DateTime article_date) {
		this.article_date = article_date;
	}
	
	
	
}
