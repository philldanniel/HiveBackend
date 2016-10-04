package com.collab.hive.model;

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

@Entity
@Table
@Component
public class ForumPostComment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cmnt_seq")
	@SequenceGenerator(
			name="cmnt_seq",
			sequenceName="cmnt_sequence",
			initialValue=1,
			allocationSize=1)
	private int comment_id;
	@ManyToOne
	@JoinColumn(name="user_id",referencedColumnName= "user_id")
	private UserDetails member;
	@ManyToOne
	@JoinColumn(name="post_id",referencedColumnName= "post_id")
	private ForumPost post_id;
	@Column(length=1000, nullable = false)
	private String post_comment;
	@Column(nullable = false)
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime postcmnt_date;
	
	
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public UserDetails getMember() {
		return member;
	}
	public void setMember(UserDetails member) {
		this.member = member;
	}
	public ForumPost getPost_id() {
		return post_id;
	}
	public void setPost_id(ForumPost post_id) {
		this.post_id = post_id;
	}
	public String getPost_comment() {
		return post_comment;
	}
	public void setPost_comment(String post_comment) {
		this.post_comment = post_comment;
	}
	public DateTime getPostcmnt_date() {
		return postcmnt_date;
	}
	public void setPostcmnt_date(DateTime postcmnt_date) {
		this.postcmnt_date = postcmnt_date;
	}
	
	
	
	
	
	
}
