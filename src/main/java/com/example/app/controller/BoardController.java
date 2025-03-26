package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.Board;
import com.example.app.domain.Comments;
import com.example.app.domain.User;
import com.example.app.service.BoardService;
import com.example.app.service.CommentService;
import com.example.app.service.ImageService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	private final CommentService commentService;
	private final ImageService imageService;
	private final HttpSession session;
	
	@GetMapping("")
	public String board(Model model) {
		List<Board> boards = boardService.getAllBoards();
		model.addAttribute("boards",boards);
		return "board";
	}
	
	@PostMapping("/create")
	public String board(
			@RequestParam String title,
			@RequestParam String description) {
		User user = (User)session.getAttribute("User");
		if(user != null) {
			Board board = new Board();
			board.setTitle(title);
			board.setDescription(description);
			board.setUserId(user.getId());     // ユーザーIDの設定
			boardService.createBoard(board);   // サービス層でデータベースに保存
		}
		
		return "redirect:/board";
	}
	
	@GetMapping("/{id}")
	public String thread(@PathVariable int id, Model model) {
		Board board = boardService.getIdBoard(id);
		
		if(board == null) {
			return "redirect:/board";
		}
		
		// コメント一覧を取得
		List<Comments> comments = commentService.findByThreadId(id);
	}

}
