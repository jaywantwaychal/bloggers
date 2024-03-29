/**
 * 
 */
package com.example.blogs.entities;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Jaywant
 *
 */
public class MyUserDetails implements UserDetails{

	private String username;
	private String password;
	private List<GrantedAuthority>  authorities;
	
	
	
	public MyUserDetails(UserEntity userEntity) {
		this.username = userEntity.getUsername();
		this.password = userEntity.getUserpassword();
		this.authorities = Arrays.stream(userEntity.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
				
				
				/*userEntity.getRoles().stream().map((role) -> {
			System.out.println(role.getUserRole());
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getUserRole());
			return authority;
		}).collect(Collectors.toList());*/
								
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
