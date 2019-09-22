package com.example.blogs.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
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

@Entity
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="category_sequence")
	@SequenceGenerator(name="category_sequence", sequenceName="category_sequence", allocationSize=100)
	private long category_id;
	
	private String category_name;
	private String category_details;
	
	@OneToMany(mappedBy="categoryEntity")
	@JsonIgnore
	private List<BlogEntity> blogEntities;
	
	@Temporal(TemporalType.DATE)
	private Date creation_date;
	
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_details() {
		return category_details;
	}
	public void setCategory_details(String category_details) {
		this.category_details = category_details;
	}
	public List<BlogEntity> getBlogEntities() {
		return blogEntities;
	}
	public void setBlogEntities(List<BlogEntity> blogEntities) {
		this.blogEntities = blogEntities;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	
}
