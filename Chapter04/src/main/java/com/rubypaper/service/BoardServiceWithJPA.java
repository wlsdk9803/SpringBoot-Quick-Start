package com.rubypaper.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

//@Service
public class BoardServiceWithJPA implements ApplicationRunner {
	
	// 글 목록 검색
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		
//		// EntityManager가 바로 JPA 컨테이너다.
//		EntityManager em = emf.createEntityManager();
//
//		// JPQL
//		String jpql = "select b from Board as b order by b.seq desc";
//		List<Board> boardList = em.createQuery(jpql).getResultList();
//		System.out.println("검색 결과");
//		for(Board board : boardList) {
//			System.out.println("---> " + board.toString());
//		}
//		
//		em.close();
//		emf.close();
//	}
	
	// 글 삭제
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		// 삭제할 Board 객체 검색
//		Board findBoard = em.find(Board.class, 1);
//		
//		tx.begin(); // TX 시작
//		em.remove(findBoard);
//		tx.commit(); // TX 종료
//		
//		// 자원 해제
//		em.close();
//		emf.close();
//	}
	
	// 글 수정
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		// 수정할 Board 객체 검색
//		Board findBoard = em.find(Board.class, 1);
//		
//		tx.begin(); // TX 시작
//
//		findBoard.setTitle("수정 제목");
//		findBoard.setContent("수정 내용");
//		
//		tx.commit(); // TX 종료
//		
//		// 자원 해제
//		em.close();
//		emf.close();
//	}
	
	// 글 상세조회
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
//		EntityManager em = emf.createEntityManager();
//		
//		Board findBoard = em.find(Board.class, 1);
//		System.out.println("검색 결과 : " + findBoard.toString());
//		
//		em.close();
//		emf.close();
//	}

	// 글 등록
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// EntityManagerFactory 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		
		// EntityManager 생성
		EntityManager em = emf.createEntityManager();
		
		// EntityTransaction 생성
		EntityTransaction tx = em.getTransaction();
		
		tx.begin(); // TX 시작
		for(int i=1; i<=5; i++) {
			Board board = new Board();
			board.setTitle("JPA 테스트");
			board.setWriter("테스터");
			board.setContent("JPA 테스트 중입니다.");
			em.persist(board);	
		}
		tx.commit(); // TX 종료
		
		// 자원 해제
		em.close();
		emf.close();
	}
}
