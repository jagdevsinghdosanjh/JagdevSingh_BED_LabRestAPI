package com.gl.studentdebate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gl.studentdebate.service.UserService;

public class MySecurityConfig extends WebSecurityConfiguration {
	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/registration/**","/save").permitAll()
		.requestMatchers("/update", "/delete").hasRole("ROLE_ADMIN")
				.anyRequest().authenticated().and().formLogin().loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser").permitAll()
				.and().logout().permitAll().and().exceptionHandling()
				.accessDeniedPage("/access-denied").and().httpBasic();
	}

	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

}
