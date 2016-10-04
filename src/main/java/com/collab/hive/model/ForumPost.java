package com.collab.hive.model;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class ForumPost {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="frmPst_seq")
	@SequenceGenerator(
			name="frmPst_seq",
			sequenceName="frmPst_sequence",
			initialValue=1,
			allocationSize=1)
	private int post_id;
	@ManyToOne
	@JoinColumn(name="forum_id",referencedColumnName= "forum_id")
	private Forum forum_id;
	@Column(length=100, nullable = false)
	private String post_name;
	@Column(length=1500, nullable = false)
	private String post;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime post_date;
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName= "user_id")
	private UserDetails post_creator;
	private int status;
	
	@OneToMany(mappedBy="post_id", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumPost> forumsPost;

	
	
	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public Forum getForum_id() {
		return forum_id;
	}

	public void setForum_id(Forum forum_id) {
		this.forum_id = forum_id;
	}

	public String getPost_name() {
		return post_name;
	}

	public void setPost_name(String post_name) {
		this.post_name = post_name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}
	
	public DateTime getPost_date() {
		return post_date;
	}

	public void setPost_date(DateTime post_date) {
		this.post_date = post_date;
	}

	public UserDetails getPost_creator() {
		return post_creator;
	}

	public void setPost_creator(UserDetails post_creator) {
		this.post_creator = post_creator;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<ForumPost> getForumsPost() {
		return forumsPost;
	}

	public void setForumsPost(List<ForumPost> forumsPost) {
		this.forumsPost = forumsPost;
	}
	
	
	
}
