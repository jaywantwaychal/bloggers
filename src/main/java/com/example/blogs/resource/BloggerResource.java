package com.example.blogs.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	//getBlog
	@GetMapping("/blogs/{blogid}")
	public BlogEntity getBlog(@PathVariable ("blogid") long blogid) {
		return service.getblog(blogid);
	}
	//get all blogs for user
	@GetMapping("/blogs/user/{userId}")
	public List<BlogEntity> getBlogsForUser(@PathVariable ("userId") long userId) {
		return service.getAllAvailableBlogsForUser(userId);
	}
	
	//get all blogs for category
	@GetMapping("/blogs/category/{categoryId}")
	public List<BlogEntity> getBlogsForCategory(@PathVariable("categoryId") long categoryId) {
		return service.getAllAvailableBlogsForCategory(categoryId);
	}
	
	//add blog
	@PostMapping("/blogs/addblog")
	public BlogEntity addBlog(@RequestBody BlogEntity blog) {
		return service.addBlog(blog);
	}
	
	//update blog
	@PutMapping("/blogs/updateblog/{blogid}")
	public BlogEntity updateBlog(@PathVariable ("blogid") long blogid, @RequestBody BlogEntity updatedBlog) {
		return service.updateBlogDetails(blogid, updatedBlog);
	}
	
	//delete blog
	@DeleteMapping("/blogs/deleteblog/{blogid}")
	public BlogEntity deleteBlog(@PathVariable ("blogid") long blogid) {
		return service.deleteBlog(blogid);
	}
	
	
}
