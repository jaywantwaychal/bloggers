package com.example.blogs.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogs.entities.BlogEntity;
import com.example.blogs.repositories.BloggesRepository;

@Service
public class BloggerService {
	
	@Autowired
	private BloggesRepository bloggesRepository;

	public List<BlogEntity> getAllAvailableBlogs() {
		return bloggesRepository.findAll();
	}

	public List<BlogEntity> getAllAvailableBlogsForUser(long userId) {
		return bloggesRepository.findBlogEntitiesByUserEntity(userId);
	}

	public List<BlogEntity> getAllAvailableBlogsForCategory(long categoryId) {
		return bloggesRepository.getAllAvailableBlogsForCategory(categoryId);
	}

	public BlogEntity addBlog(BlogEntity blog) {
		blog.setCreation_date(Calendar.getInstance().getTime());
		return bloggesRepository.save(blog);
	}

	public BlogEntity updateBlogDetails(long blogid, BlogEntity updatedBlog) {
		Optional<BlogEntity> oldBlog = bloggesRepository.findById(blogid);
		return oldBlog.map(availableblog -> {
			availableblog.setBlog(updatedBlog.getBlog());
			bloggesRepository.save(availableblog);
			return availableblog;
		}).orElseGet(() -> {
			return null;
		});
	}

	public BlogEntity getblog(long blogid) {
		Optional<BlogEntity> oldBlog = bloggesRepository.findById(blogid);
		return oldBlog.map(availableblog -> {
			return availableblog;
		}).orElseGet(() -> {
			return null;
		});
	}

	public BlogEntity deleteBlog(long blogid) {
		BlogEntity blog = getblog(blogid);
		if(null != blog) {
			bloggesRepository.deleteById(blogid);
		}
		return blog;
	}	
}
