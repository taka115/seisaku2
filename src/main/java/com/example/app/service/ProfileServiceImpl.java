package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.User;
import com.example.app.mapper.ProfileMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
	
	private final ProfileMapper profileMapper;

	@Override
	public void updateUser(User user) {
		profileMapper.updateUser(user);
	}

	@Override
	public User getUserById(int id) {
		return profileMapper.findById(id);
	}
	

}
