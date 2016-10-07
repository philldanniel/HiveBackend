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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
@Component
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="urseq")
	@SequenceGenerator(
			name="urseq",
			sequenceName="userRoleSequence",
			initialValue=1,
			allocationSize=1)
	private int id; 
		
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"first_name","last_name","email_id","mobile_no","password","status"})
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
