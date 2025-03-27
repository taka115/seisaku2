package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Images;

@Mapper
public interface ImageMapper {
	
	List <Images> findByThreadId(int id);

}
