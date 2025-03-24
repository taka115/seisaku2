package com.example.app.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Threads {
	
	private int id;
	private String description;
	private int userld;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

}
