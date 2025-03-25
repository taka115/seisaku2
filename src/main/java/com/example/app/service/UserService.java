package com.example.app.service;

import com.example.app.domain.User;

public interface UserService {
	
	void registerUser(User user);
	
	User login(String username, String password);

}
