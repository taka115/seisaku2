package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.User;
import com.example.app.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserMapper userMapper;

	@Override
	public void registerUser(User user) {
		 userMapper.insertUser(user);
		
	}

	@Override
	public User login(String username, String password) {
		User user = userMapper.findByUsername(username);
		
		 if(user != null || user.getPassword().equals(password)) {
			 return user; // ログイン成功
		 }
		
		return null; // ログイン成功
	}

}
