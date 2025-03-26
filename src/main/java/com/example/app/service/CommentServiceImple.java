package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.Comments;
import com.example.app.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImple  implements CommentService{
	
	private final CommentMapper commentMapper;

	@Override
	public Comments findByThreadId(int id) {
		return commentMapper.findByThreadId(id);
	}

}
