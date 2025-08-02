package com.rubypaper.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.jdbc.ConnectionManager;
import com.rubypaper.persistence.BoardDAO;

// ApplicationRunner를 구현한 객체가 생성되면 자동으로 run() 메소드가 실행된다.
@Service
public class BoardService implements ApplicationRunner {
	
	@Autowired
	private BoardDAO boardDAO;
	
	public BoardService() {
		System.out.println("===> BoardService 생성");
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 글 등록
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("TITLE", "Spring JDBC 테스트");
		board.put("WRITER", "테스터");
		board.put("CONTENT", "Spring JDBC 테스트 중입니다.");
		boardDAO.insertBoard(board);
		
		// 글 목록 검색
		List<Map<String, Object>> boardList = boardDAO.getBoardList();
		for (Map<String, Object> row : boardList) {
			System.out.println("---> " + row.toString());
		}
	}
}







