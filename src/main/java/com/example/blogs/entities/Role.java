package com.example.blogs.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotEmpty;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_sequence")
	@SequenceGenerator(name="role_sequence", sequenceName="role_sequence", allocationSize=100)
	private long role_id;
	
	@NotEmpty
	private String userRole;
	
	//@ManyToMany(mappedBy="roles")
	//private List<UserEntity> users;

	public long getRole_id() {
		return role_id;
	}

	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/*
	 * public List<UserEntity> getUsers() { return users; }
	 * 
	 * public void setUsers(List<UserEntity> users) { this.users = users; }
	 */

}
