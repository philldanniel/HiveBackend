package com.collab.hive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class ForumMember {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="frmMbr_seq")
	@SequenceGenerator(
			name="frmMbr_seq",
			sequenceName="frmMbr_sequence",
			initialValue=1,
			allocationSize=1)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="forum_id",referencedColumnName= "forum_id")
	private Forum forum;
	
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName= "user_id")
	private UserDetails forum_member;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public UserDetails getForum_member() {
		return forum_member;
	}

	public void setForum_member(UserDetails forum_member) {
		this.forum_member = forum_member;
	}
	
	
	
}
