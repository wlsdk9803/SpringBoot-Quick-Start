package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;
import com.rubypaper.service.BoardService;

@RestController
public class BoardController {
	
	// BoardService 타입의 객체(BoardServiceImpl)를 주입한다.
	@Autowired
	private BoardService boardService;
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello.do")
	public String hello(String name) {
		System.out.println("---> hello() 메소드 실행");
		return boardService.hello(name);
	}
	
	@GetMapping("/getBoard.do")
	public Map<String, Object> getBoard(int seq) {
		System.out.println("---> getBoard() 메소드 실행");
		return boardService.getBoard(seq);
	}
	
	@GetMapping("/getBoardList.do")
	public List<Map<String, Object>> getBoardList() {
		System.out.println("---> getBoardList() 메소드 실행");
		return boardService.getBoardList();
	}
}







