package com.example.app.service;

import org.springframework.stereotype.Service;

import com.example.app.domain.Images;
import com.example.app.mapper.ImageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private final ImageMapper imageMapper;
	
    @Override
	public Images findByThreadId(int id) {
		return imageMapper.findByThreadId(id);
	}

}
