package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.User;
import com.example.app.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	private final HttpSession session;
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(
			@RequestParam String username,
			@RequestParam String password
			) {
		User user= new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.registerUser(user);
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam String username,
			@RequestParam String password
			) {
		User user = userService.login(username, password);
		
		if(user != null) {
			session.setAttribute("User", user);
			return "redirect:/board";
			
		} else {
			return"redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/user/login";
	}
	

}
