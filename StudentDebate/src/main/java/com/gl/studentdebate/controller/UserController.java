package com.gl.studentdebate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.studentdebate.model.UserRegistrationDto;
import com.gl.studentdebate.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}

	/*
	 * @ModelAttribute("user") public UserRegistrationDto userRegistation() { return
	 * new UserRegistrationDto(); }
	 */

	@PostMapping
	public String registrationUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
