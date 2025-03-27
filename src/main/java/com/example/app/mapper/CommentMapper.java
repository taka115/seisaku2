package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Comment;

@Mapper
public interface CommentMapper {
	
	List <Comment> findByThreadId(int id);
	void insertComment(Comment comment);

}
