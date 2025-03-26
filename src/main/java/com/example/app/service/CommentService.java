package com.example.app.service;

import com.example.app.domain.Comments;

public interface CommentService {
	
	Comments findByThreadId(int id);

}
