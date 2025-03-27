package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Comment;
import com.example.app.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImple  implements CommentService{
	
	private final CommentMapper commentMapper;

	@Override
	public List <Comment> findByThreadId(int id) {
		return commentMapper.findByThreadId(id);
	}

	@Override
	public void insertCommemt(Comment comment) {
	    commentMapper.insertComment(comment);
	}
	
	

}
