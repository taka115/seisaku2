package com.example.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Comments;

@Mapper
public interface CommentMapper {
	
	Comments findByThreadId(int id);

}
