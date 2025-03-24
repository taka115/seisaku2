package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Comments {
	
	private int id;
	private String content;
	private int userId;
	private int threadId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	

}