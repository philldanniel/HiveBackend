package com.collab.hive.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@Component
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
public class UserDetails implements Serializable {
	@Id
	private String user_id;
	private String first_name;
	private String last_name;
	private String email_id;
	private String mobile_no;
	private String password;
	private int status;
	
	@OneToMany(mappedBy="userDetails", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private Set<UserRole> userRoles;
	
	@OneToMany(mappedBy="blogger", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Blog> blogs;
	
	@OneToMany(mappedBy="user_id", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<BlogComment> comments;
	
	@OneToMany(mappedBy="forum_creator", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<Forum> forums;
	
	@OneToMany(mappedBy="post_creator", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumPost> forumPosts;
	
	@OneToMany(mappedBy="member", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumPostComment> forumPostComments;
	
	@OneToMany(mappedBy="forum_member", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumMember> forumMembers;
	
	
	
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<BlogComment> getComments() {
		return comments;
	}

	public void setComments(List<BlogComment> comments) {
		this.comments = comments;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public List<ForumPost> getForumPosts() {
		return forumPosts;
	}

	public void setForumPosts(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public List<ForumPostComment> getForumPostComments() {
		return forumPostComments;
	}

	public void setForumPostComments(List<ForumPostComment> forumPostComments) {
		this.forumPostComments = forumPostComments;
	}

	public List<ForumMember> getForumMembers() {
		return forumMembers;
	}

	public void setForumMembers(List<ForumMember> forumMembers) {
		this.forumMembers = forumMembers;
	}
	
	

}
