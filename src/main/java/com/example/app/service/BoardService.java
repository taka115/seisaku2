package com.example.app.service;

import java.util.List;

import com.example.app.domain.Board;

public interface BoardService {
	
	void createBoard(Board board);
	
	List<Board> getAllBoards();
	

}
