package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Images {
	
	private int id;
	private String fileName;
	private String filePath;
	private int userId;
	private int commentId;
	private LocalDateTime createdAt;

}
