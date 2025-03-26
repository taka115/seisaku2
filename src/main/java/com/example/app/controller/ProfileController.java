package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.User;
import com.example.app.service.ProfileService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfileController {
	
	private final ProfileService profileService;
	private final HttpSession session;
	
	// プロフィール編集ページの表示
	@GetMapping("/user/profile")
	public String profile(Model model) {
		// ログイン中のユーザーを取得
		User user = (User) session.getAttribute("User");
		
		if(user == null) {
			return "redirect:/login";
		}
		
		// ユーザー情報を取得してモデルに追加
		User userInfo = profileService.getUserById(user.getId());
		model.addAttribute("user", userInfo);
		return "profile";
	}
	
	// プロフィール更新処理
	@PostMapping("/profile")
	public String Profile(
			@RequestParam String username,
			@RequestParam String password,
			@RequestParam String passwordConfirm,
			Model model) {
		
		User user = (User) session.getAttribute("User");
		
		if(user == null) {
			return "redirect:/login";
		}
		
		// パスワードの一致チェック
		if(!password.equals(passwordConfirm)) {
			model.addAttribute("error", "パスワードが一致しません");
			return "profile";
		}
		
		// ユーザー情報を更新
		user.setUsername(username);
		user.setPassword(password);
		profileService.updateUser(user);
		
		// 更新後の情報をセッションに保存
		session.setAttribute("User", user);
		
		return "redirect:/user/profile";
	}

}
