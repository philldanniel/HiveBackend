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
public class Forum {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="frm_seq")
	@SequenceGenerator(
			name="frm_seq",
			sequenceName="frm_sequence",
			initialValue=1,
			allocationSize=1)
	private int forum_id;
	@Column(length=100, nullable = false)
	private String forum_name;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime forum_date;
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName= "user_id")
	private UserDetails forum_creator;
	
	@OneToMany(mappedBy="forum_id", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumPost> forumPosts;
	
	@OneToMany(mappedBy="forum", fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	private List<ForumMember> forumMembers;
	
	
	
	
	
	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}

	public String getForum_name() {
		return forum_name;
	}

	public void setForum_name(String forum_name) {
		this.forum_name = forum_name;
	}

	public DateTime getForum_date() {
		return forum_date;
	}

	public void setForum_date(DateTime forum_date) {
		this.forum_date = forum_date;
	}

	public UserDetails getForum_creator() {
		return forum_creator;
	}

	public void setForum_creator(UserDetails forum_creator) {
		this.forum_creator = forum_creator;
	}

	public List<ForumPost> getForumPosts() {
		return forumPosts;
	}

	public void setForumPosts(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public List<ForumMember> getForumMembers() {
		return forumMembers;
	}

	public void setForumMembers(List<ForumMember> forumMembers) {
		this.forumMembers = forumMembers;
	}
	
	
	
	
	

}
