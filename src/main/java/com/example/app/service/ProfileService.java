package com.example.app.service;

import com.example.app.domain.User;

public interface ProfileService {
	
	User getUserById(int id);
	
	void updateUser(User user);
	

}
