package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// 글 등록 화면으로 이동
	@GetMapping("/insertBoardView.do")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	// 글 등록 처리
	@PostMapping("/insertBoard.do")
	public String insertBoard(Board board) {
		boardService.insertBoard(board);
		// 글 등록 성공 후, 목록 화면으로 이동
		return "redirect:getBoardList.do";
	}
	
	// 글 수정 처리
	@PostMapping("/updateBoard.do")
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:getBoardList.do";
	}
	
	// 글 사제 처리
	@GetMapping("/deleteBoard.do")
	public String deleteBoard(Board board) {
		boardService.deleteBoard(board);
		return "redirect:getBoardList.do";
	}
	
	// 긂 상세 조회
	@GetMapping("/getBoard.do")
	public String getBoard(Board board, Model model) {
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	// 긂 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(Board board, Model model) {
		
		// 검색 결과를 Model 저장한다.
		model.addAttribute("boardList", boardService.getBoardList(board));
		return "getBoardList";
	}
}







