package com.rubypaper;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	// 스프링이 제공하는 BoardRepository 인터페이스 구현 객체를 주입한다.
	@Autowired
	private BoardRepository boardRepository;
	
	@Test
	public void testDeleteBoard() {
		boardRepository.deleteById(1);
	}
	
	//@Test
	public void testUpdateBoard() {
		Board board = new Board();
		board.setSeq(1);
		board.setTitle("---수정 제목");
		boardRepository.save(board);
	}
	
	//@Test
	public void testGetBoardList() {
		List<Board> boardList = boardRepository.findAll();
		System.out.println("[ 검색 결과 ]");
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	//@Test
	public void testGetBoard() {
		Board board = boardRepository.findById(1).get();
		System.out.println("검색 결과 : " + board.toString());
		
//		Optional<Board> findObject = boardRepository.findById(1);
//		if(findObject.isPresent()) {
//			Board board = findObject.get();
//			System.out.println("검색 결과 : " + board.toString());
//		}
	}
	
	//@Test
	public void testInsertBoard() {
		Board board = new Board();
		board.setTitle("Spring-JPA 테스트");
		board.setWriter("테스터");
		board.setContent("Spring-JPA 테스트 중입니다.");
		boardRepository.save(board);
	}
}






