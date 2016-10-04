package com.collab.hive.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Role {
	public Role(int role_id, String role_name) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
	}
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="role_seq")
	@SequenceGenerator(
			name="role_seq",
			sequenceName="newrole_sequence",
			initialValue=1,
			allocationSize=1)
	private int role_id;
	@Column(unique=true)
	private String role_name;
	
	/*@OneToMany(mappedBy="role", fetch = FetchType.EAGER)
	private Set<UserRole> userRoles;
	
	
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}*/

	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	

}
