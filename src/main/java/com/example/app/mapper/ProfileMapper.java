package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.User;

@Mapper
public interface ProfileMapper {
	
	User findById(int id);
	
	void updateUser(User user);

}
