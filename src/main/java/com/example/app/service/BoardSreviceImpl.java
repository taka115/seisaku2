package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.app.domain.Board;
import com.example.app.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardSreviceImpl implements BoardService {
	
	private final BoardMapper boardMapper;

	@Override
	public void createBoard(Board board) {
		boardMapper.insertBoard(board);
	}

	@Override
	public List<Board> getAllBoards() {
		return boardMapper.findAll();
	}

	@Override
	public Board getIdBoard(int id) {
		boardMapper.findById(id);
		return null;
	}

}
