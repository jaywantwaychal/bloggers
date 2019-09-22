package com.example.blogs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CommentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="comment_sequence")
	@SequenceGenerator(name="comment_sequence", sequenceName="comment_sequence", allocationSize=100)
	private long comment_id;
	
	private String comment;
	
	
	  @ManyToOne
	  
	  @JoinColumn(name="blog_id")
	 
	private BlogEntity blogEntity;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userCommentEntity;
	
	@Temporal(TemporalType.DATE)
	private Date creation_date;

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public BlogEntity getBlogEntity() {
		return blogEntity;
	}

	public void setBlogEntity(BlogEntity blogEntity) {
		this.blogEntity = blogEntity;
	}

	public UserEntity getUserCommentEntity() {
		return userCommentEntity;
	}

	public void setUserCommentEntity(UserEntity userCommentEntity) {
		this.userCommentEntity = userCommentEntity;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
	
	
}
