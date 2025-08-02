package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubypaper.domain.BoardVO;

//@Controller
@RestController // 모든 메소드 리턴 타입 앞에 자동으로 @ResponseBody를 추가한다.
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//@RequestMapping(value = "/hello.do", method = RequestMethod.GET)
	@GetMapping("/hello.do")
	public String hello(String name) {
		System.out.println("---> hello() 메소드 실행");
		return "hello : " + name;
	}
	
	//@RequestMapping(value = "/getBoard.do", method = RequestMethod.GET)
	@GetMapping("/getBoard.do")
	public BoardVO getBoard(int seq) {
		System.out.println("---> getBoard() 메소드 실행");
		BoardVO board = new BoardVO();
		board.setSeq(1);
		board.setTitle("Spring Boot 테스트");
		board.setWriter("테스터");
		board.setContent("Spring Boot 테스트 중입니다.");
		board.setRegDate(new Date());
		board.setCnt(12);
		return board;
	}
	
	//@RequestMapping(value = "/getBoardList.do", method = RequestMethod.GET)
	@GetMapping("/getBoardList.do")
	public List<BoardVO> getBoardList() {
		System.out.println("---> getBoardList() 메소드 실행");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		
		for (int i = 1; i <= 5; i++) {
			BoardVO board = new BoardVO();
			board.setSeq(i);
			board.setTitle("Spring Boot 테스트-" + i);
			board.setWriter("테스터");
			board.setContent("Spring Boot 테스트 중입니다.-" + i);
			board.setRegDate(new Date());
			board.setCnt(i);
			boardList.add(board);
		}
		
		return boardList;
	}
}







