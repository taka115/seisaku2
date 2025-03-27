package com.example.app.service;

import java.util.List;

import com.example.app.domain.Images;

public interface ImageService {
	
	List<Images> findByThreadId(int id);

}
