package com.greatlearning.srs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.greatlearning.srs.security.entity.Role;
import com.greatlearning.srs.security.entity.User;

@SuppressWarnings("serial")
public class SrsUserDetails implements UserDetails{

	private User userObj;
	
	public SrsUserDetails(User userObj) {
		
		this.userObj = userObj;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> resturnResult =
			new ArrayList<>();
		
		List<Role> roles = userObj.getRoles();
		
		for (Role roleObj : roles) {
			
			String rName = roleObj.getName();
			
			SimpleGrantedAuthority sga = 
				new SimpleGrantedAuthority(rName);
			
			resturnResult.add(sga);
		}
		return resturnResult;
	}

	@Override
	public String getPassword() {
		
		return userObj.getPassword();
	}

	@Override
	public String getUsername() {

		return userObj.getUsername();

	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}	
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}