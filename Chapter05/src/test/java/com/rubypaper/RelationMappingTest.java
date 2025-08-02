package com.rubypaper;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.User;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Test
	public void cascadeTest() {
		userRepository.deleteById("user02");
	}
	
	//@Test
	@Transactional
	public void manyToOneBothWayMappingTest() {
//		// Many에 해당하는 Board를 검색한다.
//		Board board = boardRepository.findById(5).get();
//		System.out.println("게시글 번호 : " + board.getSeq());
//		System.out.println("제목 : " + board.getTitle());
//		
//		System.out.println("작성자 : " + board.getUser().getName());
		
		// One에 해당하는 User를 검색한다.
		User user = userRepository.findById("user01").get();
		
		System.out.println(user.getName() + "가 등록한 게시글 목록");
		List<Board> boardList = user.getBoardList();
		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	//@Test
	@Transactional
	public void manyToOneOneWayMappingTest() {
		// Many에 해당하는 Board를 검색한다.
		Board board = boardRepository.findById(5).get();
		System.out.println("게시글 번호 : " + board.getSeq());
		System.out.println("제목 : " + board.getTitle());
		
		System.out.println("작성자 : " + board.getUser().getName());
	}
	
	//@BeforeEach
	public void dataInit() {
		// 회원 등록
		User user1 = new User();
		user1.setId("user01");
		user1.setName("둘리");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setId("user02");
		user2.setName("도우너");
		userRepository.save(user2);
		
		// 게시글 등록
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("둘리가 등록한 게시글-" + i);
			board.setUser(user1);
			boardRepository.save(board);
		}
		
		for (int i = 1; i <= 3; i++) {
			Board board = new Board();
			board.setTitle("도우가 등록한 게시글-" + i);
			board.setUser(user2);
			boardRepository.save(board);
		}
	}
}






