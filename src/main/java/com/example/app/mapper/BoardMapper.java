package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.domain.Board;

@Mapper
public interface BoardMapper {
	
	void insertBoard(Board board);
	
	List<Board> findAll();

}
