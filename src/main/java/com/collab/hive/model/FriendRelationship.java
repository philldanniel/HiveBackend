package com.collab.hive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class FriendRelationship {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="frnd_seq")
	@SequenceGenerator(
			name="frnd_seq",
			sequenceName="frnd_sequence",
			initialValue=1,
			allocationSize=1)
	private int id;
	private String user_id_one;
	private String user_id_two;
	private int status;
	private String action_user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id_one() {
		return user_id_one;
	}
	public void setUser_id_one(String user_id_one) {
		this.user_id_one = user_id_one;
	}
	public String getUser_id_two() {
		return user_id_two;
	}
	public void setUser_id_two(String user_id_two) {
		this.user_id_two = user_id_two;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAction_user_id() {
		return action_user_id;
	}
	public void setAction_user_id(String action_user_id) {
		this.action_user_id = action_user_id;
	}
	
	

}
