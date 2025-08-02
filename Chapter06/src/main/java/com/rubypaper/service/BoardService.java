package com.rubypaper.service;

import java.util.List;

import com.rubypaper.domain.Board;

public interface BoardService {

	// 글 등록
	void insertBoard(Board board);

	// 글 수정
	void updateBoard(Board board);

	// 글 삭제
	void deleteBoard(Board board);

	// 글 상세 조회
	Board getBoard(Board board);

	// 글 목록 검색
	List<Board> getBoardList(Board board);

}