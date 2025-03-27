package com.example.app.service;

import java.util.List;

import com.example.app.domain.Comment;

public interface CommentService {
	
	List <Comment> findByThreadId(int id);
	void insertCommemt(Comment comment);

}
