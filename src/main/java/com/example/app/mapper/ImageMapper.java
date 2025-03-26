package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Images;

@Mapper
public interface ImageMapper {
	
	Images findByThreadId(int id);

}
