package com.greatlearning.srs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SrsSecurityCustomizer extends WebSecurityConfiguration {
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.authenticationProvider(srsAuthenticationProvider());
	}

	@Bean
	public AuthenticationProvider srsAuthenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());

		authProvider.setPasswordEncoder(getPasswordEncoder());

		return authProvider;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		return new SrsUserDetailService();
	}

	
	@SuppressWarnings("deprecation")
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().requestMatchers("/", "/students/save", "/students/showFormForAdd", "/students/403")
				.hasAnyAuthority("USER", "ADMIN").requestMatchers("/students/showFormForUpdate", "/students/delete")
				.hasAuthority("ADMIN").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.successForwardUrl("/students/list").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/students/403").and().cors().and().csrf().disable();
	}
}
