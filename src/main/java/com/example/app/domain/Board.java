package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Board {
	
	private int id;
	private String title;
	private String description;
	private int userId;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
