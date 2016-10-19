package com.collab.hive.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table
@Component
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "blog_id")
@JsonSerialize
public class Blog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4326512339446989452L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="blog_seq")
	@SequenceGenerator(
			name="blog_seq",
			sequenceName="newblogsequence",
			initialValue=1,
			allocationSize=1)
	private int blog_id;
	@Column(length=100, nullable = false)
	private String blog_name;
	@Column(length=1500, nullable = false)
	private String blog;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime blog_date;
	private int status;
	
	
	

	@ManyToOne(optional = false)
	@JoinColumn(name="user_id",referencedColumnName= "user_id"/*, updatable = false, insertable = false*/)
	
	private UserDetails blogger;
	
	
	@OneToMany(mappedBy="blog_id", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<BlogComment> blogComments;

	public int getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog_name() {
		return blog_name;
	}

	public void setBlog_name(String blog_name) {
		this.blog_name = blog_name;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public DateTime getBlog_date() {
		return blog_date;
	}

	public void setBlog_date(DateTime blog_date) {
		this.blog_date = blog_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public UserDetails getBlogger() {
		return blogger;
	}

	public void setBlogger(UserDetails blogger) {
		this.blogger = blogger;
	}

	public List<BlogComment> getBlogComments() {
		return blogComments;
	}

	public void setBlogComments(List<BlogComment> blogComments) {
		this.blogComments = blogComments;
	}
	
	
	

}
