package com.gl.studentdebate.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gl.studentdebate.model.User;
import com.gl.studentdebate.model.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	public User save(UserRegistrationDto registrationDto);

}
