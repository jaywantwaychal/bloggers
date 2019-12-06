package com.example.blogs.service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.blogs.entities.MyUserDetails;
import com.example.blogs.entities.UserEntity;
import com.example.blogs.repositories.UserRepository;

@Service
@Transactional
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	private BCryptPasswordEncoder bce = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * UserEntity user = userRepository.findByUser_name(username).orElseThrow(() ->
		 * new UsernameNotFoundException("No user found")); return new
		 * org.springframework.security.core.userdetails.User(user.getUser_name(),
		 * user.getUser_password(), getAuthorities(user));
		 */
		
		Optional<UserEntity> userEntity = userRepository.findByUsername(username);
		userEntity.orElseThrow(() -> {
			throw new UsernameNotFoundException("User Not Found !");
		});
		return userEntity.map(MyUserDetails::new).get();
	}

	/*
	 * private Collection<? extends GrantedAuthority> getAuthorities(UserEntity
	 * user) {
	 * 
	 * String[] userroles = user.getRoles().stream().map((role) ->
	 * role.getUserRole()).toArray(String[]::new); Collection<GrantedAuthority>
	 * authorities = AuthorityUtils.createAuthorityList(userroles); return
	 * authorities; }
	 */

	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<UserEntity> getUserDetails(long user_id) {
		return userRepository.findById(user_id);
	}

	public UserEntity addUser(UserEntity user) {
		
		user.setUserpassword(bce.encode((CharSequence)user));
		user.setCreation_date(Calendar.getInstance().getTime());
		return userRepository.save(user);
	}

	public UserEntity updateUserDetails(UserEntity user, long userId) throws UsernameNotFoundException{
		
		Optional<UserEntity> availableUserEntity = getUserDetails(userId);
		
		availableUserEntity.orElseThrow(() -> {
			throw new UsernameNotFoundException("User Not Found !");
		});
		
		return availableUserEntity.map(availableUser -> 
							{
								availableUser.setUsername(user.getUsername());
								availableUser.setUserpassword(bce.encode((CharSequence)user.getUserpassword()));
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
