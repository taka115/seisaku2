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
import com.example.app.domain.Comment;
import com.example.app.domain.Images;
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
		 System.out.println("Received id: " + id);
		Board board = boardService.getIdBoard(id);
		
		if(board == null) {
			System.out.println("Board not found for id: " + id);
			return "redirect:/board";
		}
		
		// コメント一覧を取得
		List<Comment> comments = commentService.findByThreadId(id);
		System.out.println("Comments: " + comments.size() + "件取得");
		
		// 画像一覧を取得
		List<Images> images = imageService.findByThreadId(id);
		System.out.println("Images: " + images.size() + "件取得");

		// モデルにデータを追加
		model.addAttribute("board", board);
		model.addAttribute("comments", comments);
		model.addAttribute("images", images);
		
		return "keijiban";
	}
	
	@PostMapping("/comment")
	public String comment (@RequestParam int threadId, 
			@RequestParam String content) {
		User user = (User) session.getAttribute("User");
		if(user != null) {
			Comment comment = new Comment();
			comment.setThreadId(threadId);
			comment.setUserId(user.getId());
			comment.setContent(content);
			commentService.insertCommemt(comment);
		}
		
		return "redirect:/board/" + threadId;
	}

}
