package com.rubypaper.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	private static final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) VALUES((SELECT NVL(MAX(SEQ), 0) + 1 FROM BOARD), ?, ?, ?)";
	private static final String BOARD_LIST   = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	@Autowired
	private JdbcTemplate spring;
	
	public void insertBoard(Map<String, Object> board) {
		spring.update(BOARD_INSERT, board.get("TITLE"), board.get("WRITER"), board.get("CONTENT"));
	}
	
	public List<Map<String, Object>> getBoardList() {
		return spring.queryForList(BOARD_LIST);
	}
}
