package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

// JpaRepository를 상속한 인터페이스를 정의하면 스프링이 구현 클래스를 자동으로 제공한다.
public interface BoardRepository extends JpaRepository<Board, Integer> {
	
	// Query 메소드 선언
	// SELECT b FROM Board AS b WHERE b.title = ?
	List<Board> findByTitle(String keyword);
	
	// SELECT b FROM Board AS b WHERE b.title LIKE ?
	List<Board> findByTitleContaining(String keyword);
	
	// SELECT b FROM Board AS b WHERE b.title LIKE ? OR b.content LIKE ?
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// SELECT b FROM Board AS b WHERE b.title LIKE ? ORDER BY b.seq DESC
	List<Board> findByTitleContainingOrderBySeqDesc(String keyword);
	
	// 페이징 처리
	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	
	@Query("SELECT b.seq, b.title, b.writer FROM Board b WHERE b.title LIKE %?1% ORDER BY b.seq DESC")
	List<Object[]> getBoardListByJPQL(String keyword);
	
	@Query(value = "select seq, title, writer, content from board where title like '%'||:keyword||'%' order by seq desc", 
		   nativeQuery = true)
	List<Object[]> getBoardListBySQL(@Param("keyword") String keyword);
	
}






