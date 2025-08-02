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

@Service
public class LifeCycleService implements ApplicationRunner {
	
	// 글 등록
	@Override
	public void run(ApplicationArguments args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		tx.begin(); // TX 시작
//
		Board board = new Board();
		board.setSeq(2);
		board.setTitle("merge 테스트");
		board.setWriter("테스터");
		board.setContent("merge 테스트 중입니다.");
		em.merge(board);
		
		tx.commit();
		
		// 컨테이너를 종료(close)하는 순간 컨테이너가 관리하던 모든 엔티티는 준영속 상태로 빠진다.
		em.close();
		emf.close();
	} 
}
