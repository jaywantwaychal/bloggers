package com.example.blogs.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogs.entities.UserEntity;
import com.example.blogs.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<UserEntity> getUserDetails(long user_id) {
		return userRepository.findById(user_id);
	}

	public UserEntity addUser(UserEntity user) {
		user.setCreation_date(Calendar.getInstance().getTime());
		return userRepository.save(user);
	}

	public UserEntity updateUserDetails(UserEntity user, long userId) {
		
		Optional<UserEntity> availableUserEntity = getUserDetails(userId);
		return availableUserEntity.map(availableUser -> 
							{
								availableUser.setUser_name(user.getUser_name());
								availableUser.setUser_password(user.getUser_password());
								userRepository.save(availableUser);
								return availableUser;
							})
							.orElseGet(() -> {
								return null;
							});
	}

	public void deleteUser(long userId) {
		if(userRepository.existsById(userId)) {
			userRepository.deleteById(userId);
		}
	}

}
