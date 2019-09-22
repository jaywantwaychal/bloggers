package com.example.blogs.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blogs.entities.UserEntity;
import com.example.blogs.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping({"/allUsers", "/"})
	public List<UserEntity> getAllUers() {
		
		return userService.getAllUsers();
	}
	
	@GetMapping("/{userid}")
	public Optional<UserEntity> getUserDetails(@PathVariable ("userid") long user_id) {
		return userService.getUserDetails(user_id);
	}
	
	@PostMapping("/addUser")
	public UserEntity addUser(@RequestBody UserEntity user) {
		return userService.addUser(user);
	}
	
	@PutMapping("/updateUser/{userid}")
	public UserEntity updateUserDetails(@RequestBody UserEntity user, @PathVariable ("userid") long userId) {
		return userService.updateUserDetails(user, userId);
	}
	
	@DeleteMapping("/deleteUser/{userid}")
	public void deleteUser(@PathVariable ("userid") long userId) {
		userService.deleteUser(userId);
	}
}
