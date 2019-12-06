package com.example.blogs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_sequence")
	@SequenceGenerator(name="user_sequence", sequenceName="user_sequence", allocationSize=100)
	private long user_id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String userpassword;
	
	@OneToMany(mappedBy="userEntity")
	@JsonIgnore
	private List<BlogEntity> blogEntities;
	
	@OneToMany(mappedBy="userCommentEntity")
	@JsonIgnore
	private List<CommentEntity> comments;
	
	/*
	 * @ManyToMany(cascade=CascadeType.MERGE)
	 * 
	 * @JoinTable( name="user_role", joinColumns= {@JoinColumn(name="USER_ID",
	 * referencedColumnName="user_id")}, inverseJoinColumns=
	 * {@JoinColumn(name="ROLE_ID", referencedColumnName="role_id")} )
	 */
	//private List<Role> roles;
	private String roles;
	
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	
	public long getUser_id() {
		return user_id;
	}
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}
	
	public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}
	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
	}
	public List<CommentEntity> getComments() {
		return comments;
	}
	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	/*
	 * public List<Role> getRoles() { return roles; } public void
	 * setRoles(List<Role> roles) { this.roles = roles; }
	 */
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the userpassword
	 */
	public String getUserpassword() {
		return userpassword;
	}
	/**
	 * @param userpassword the userpassword to set
	 */
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	/**
	 * @return the roles
	 */
	public String getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	/*
	 * public void addBlogEntities(BlogEntity blog) { blogEntities.add(blog);
	 * blog.setUserEntity(this); }
	 */
}
