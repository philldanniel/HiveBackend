package com.collab.hive.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
		
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserDetails userDetails;

	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	

}
