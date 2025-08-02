package com.rubypaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	// 스프링이 자동으로 생성해주는 BoardRepository 타입의 객체 주입
	@Autowired
	private BoardRepository boardRepository;
	
	// 글 등록
	public void insertBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 수정
	public void updateBoard(Board board) {
		boardRepository.save(board);
	}
	
	// 글 삭제
	public void deleteBoard(Board board) {
		boardRepository.deleteById(board.getSeq());
	}
	
	// 글 상세 조회
	public Board getBoard(Board board) {
		return boardRepository.findById(board.getSeq()).get();
	}
	
	// 글 목록 검색
	public List<Board> getBoardList(Board board) {
		return boardRepository.findAll();
	}
}
