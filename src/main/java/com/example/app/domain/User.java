package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User {
	
	private int id;
	private String username;
	private String password;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
