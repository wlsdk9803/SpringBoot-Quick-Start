package com.rubypaper.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

//@Service
public class BoardServiceWithMyBatis implements ApplicationRunner {
	
	// SqlSessionTemplate 객체가 바로 MyBatis 컨테이너 객체다.
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 글 등록
		Board board = new Board();
		board.setSeq(101);
		board.setTitle("MyBatis 테스트");
		board.setWriter("테스터");
		board.setContent("MyBatis 테스트 중입니다.");
		mybatis.insert("insertBoard", board);
		
		// 글 목록 검색
		List<Board> boardList = mybatis.selectList("getBoardList");
		for (Board row : boardList) {
			System.out.println("---> " + row.toString());
		}
	}

}
