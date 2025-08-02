package com.rubypaper.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.rubypaper.domain.Board;

// 1. MyBatis는 @Mapper가 붙은 인터페이스의 구현 객체를 자동으로 제공한다.
// 2. Mapper 인터페이스는 mapper.xml 파일로 대체할 수도 있다.
@Mapper
public interface BoardMapper {
	
	@Insert("insert into board(seq, title, writer, content) values(#{seq}, #{title}, #{writer}, #{content})")
	public void insertBoard(Board board);
	
	@Select("select * from board order by seq desc")
	public List<Board> getBoardList();
}





