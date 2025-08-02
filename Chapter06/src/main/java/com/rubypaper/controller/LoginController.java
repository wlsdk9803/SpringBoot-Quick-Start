package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.rubypaper.domain.User;
import com.rubypaper.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	// 로그인 화면으로 이동
	@GetMapping("/loginView.do")
	public String loginView() {
		return "login";
	}
	
	// 로그인 인증 처리
	@PostMapping("/login.do")
	public String login(User user, HttpSession session) {
		User findUser = userService.getUser(user);
		// 비밀번호 체크
		if(findUser != null && findUser.getPassword().equals(user.getPassword())) {
			// 로그인 성공 시, 목록으로 이동하기 전에 세션에 사용자 정보를 등록한다.
			session.setAttribute("user", findUser);
			return "redirect:getBoardList.do";
		} else {
			return "redirect:loginView.do";
		}
	}
	
	// 로그아웃 처리
	@GetMapping("/logout.do")
	public String logout(SessionStatus status) {
		// 브라우저와 매핑된 세션을 강제 종료하고 메인 페이지로 이동한다.
		status.setComplete();
		return "redirect:/";
	}
}
