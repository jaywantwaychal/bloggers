package com.example.blogs.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
	
	
	

}
