package com.example.blogs.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.entities.BlogEntity;
import com.example.blogs.service.BloggerService;

@RestController
@RequestMapping("/blogger")
public class BloggerResource {

	@Autowired
	private BloggerService service;
	
	//get all blogs
	@GetMapping({"/", "/allblogs"})
	public List<BlogEntity> getAllAvailableBlogs() {
		return service.getAllAvailableBlogs();
	}
	
	//get all blogs for user
	@GetMapping("/blogs/{userId}")
	public List<BlogEntity> getBlogsForUser(@PathVariable ("userId") long userId) {
		return service.getAllAvailableBlogsForUser(userId);
	}
	
	//get all blogs for category
	
	
	//add blog
	
	//update blog
	
	//delete blog
	
	
	
}
