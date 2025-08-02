package com.rubypaper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.BoardRepository;
import com.rubypaper.persistence.BoardRepositoryQueryDSL;

@SpringBootTest
public class QueryMethodTest {

	// 스프링이 제공하는 BoardRepository 인터페이스 구현 객체를 주입한다.
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private BoardRepositoryQueryDSL boardRepositoryQueryDSL; 
	
	@Test
	public void testQueryDSL() {
		BooleanBuilder builder = new BooleanBuilder();
		
		String condition = "CONTENT";
		String keyword = "17";
		// QBoard 객체를 획득한다.
		QBoard qboard = QBoard.board;
		if(condition.equals("TITLE")) {
			builder.and(qboard.title.like("%" + keyword + "%"));
		} else if(condition.equals("CONTENT")) {
			builder.and(qboard.content.like("%" + keyword + "%"));
		}		
		
		Iterable<Board> resultList = boardRepositoryQueryDSL.findAll(builder);
		
		System.out.println("[ 검색 결과 ]");
		for (Board board : resultList) {
			System.out.println("---> " + board.toString());
		}
	}
	
	//@Test
	public void testQueryAnnotation() {
		List<Object[]> resultList = boardRepository.getBoardListBySQL("17");
		
		System.out.println("[ 검색 결과 ]");
		for (Object[] board : resultList) {
			System.out.println("---> " + Arrays.toString(board));
		}
	}
	
	//@Test
	public void testQueryMethod() {
		Pageable pageable = PageRequest.of(1, 5);
		Page<Board> pageInfo = boardRepository.findByTitleContaining("17", pageable);
		
		System.out.println("[ 검색 결과 ]");
		for (Board board : pageInfo.getContent()) {
			System.out.println("---> " + board.toString());
		}
		
		System.out.println("검색된 전체 데이터 수 : " + pageInfo.getTotalElements());
		System.out.println("전체 페이지 수 : " + pageInfo.getTotalPages());
		System.out.println("한 페이지에 출력되는 데이터 수 : " + pageInfo.getSize());
		
		if(pageInfo.hasPrevious()) {
			System.out.println("이전 페이지 정보 : " + pageInfo.previousPageable());
		}
		System.out.println("현재 페이지 정보 : " + pageInfo.getPageable());
		if(pageInfo.hasNext()) {
			System.out.println("다음 페이지 정보 : " + pageInfo.nextPageable());
		}
	}
	
	@BeforeEach
	public void dataInit() {
		for (int i = 1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("테스트 제목-" + i);
			board.setWriter("테스터");
			board.setContent("테스트 내용-" + i);
			boardRepository.save(board);
		}
	}
}






