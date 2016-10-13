package com.collab.hive.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@Component
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "comment_id")
public class BlogComment implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="blgcm_seq")
	@SequenceGenerator(
			name="blgcm_seq",
			sequenceName="newblgcm_sequence",
			initialValue=1,
			allocationSize=1)
	private int comment_id;
	@ManyToOne
	@JsonIgnoreProperties({"first_name","last_name","email_id","mobile_no","password","status"})
	@JoinColumn(name="user_id",referencedColumnName= "user_id")
	private UserDetails user_id;
	@ManyToOne
	@JsonIgnoreProperties({"blog_name","blog","blog_date","status","blogger"})
	@JoinColumn(name="blog_id",referencedColumnName= "blog_id")
	private Blog blog_id;
	@Column(length=1000, nullable = false)
	private String blog_comment;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
	private DateTime cmnt_date_time;
	
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public UserDetails getUser_id() {
		return user_id;
	}
	public void setUser_id(UserDetails user_id) {
		this.user_id = user_id;
	}
	public Blog getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(Blog blog_id) {
		this.blog_id = blog_id;
	}
	public String getBlog_comment() {
		return blog_comment;
	}
	public void setBlog_comment(String blog_comment) {
		this.blog_comment = blog_comment;
	}
	public DateTime getCmnt_date_time() {
		return cmnt_date_time;
	}
	public void setCmnt_date_time(DateTime cmnt_date_time) {
		this.cmnt_date_time = cmnt_date_time;
	}
	

}
