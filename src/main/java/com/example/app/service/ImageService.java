package com.example.app.service;

import com.example.app.domain.Images;

public interface ImageService {
	
	Images findByThreadId(int id);

}
