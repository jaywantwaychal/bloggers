package com.example.blogs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BlogEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="blog_sequence")
	@SequenceGenerator(name="blog_sequence", sequenceName="blog_sequence", allocationSize=100)
	private long blog_id;
	
	private String blog;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private CategoryEntity categoryEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="blogEntity",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<CommentEntity> comments;
	
	@Temporal(TemporalType.DATE)
	private Date creation_date;

	public long getBlog_id() {
		return blog_id;
	}

	public void setBlog_id(long blog_id) {
		this.blog_id = blog_id;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
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
	
}
