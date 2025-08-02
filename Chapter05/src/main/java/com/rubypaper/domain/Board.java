package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "user")
@Entity 
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	private String writer;	
	private String content;
	private Date regDate = new Date();	
	private int cnt = 0;
	
	// Many(Board) 객체를 검색할 때, 연관된 One(User) 객체도 같이 가져와라.
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	// 1. BOARD 테이블에 USER_ID 컬럼을 추가하고 FK 제약조건을 설정해라.
	// 2. BOARD 데이터를 저장할 때, user가 참조하는 객체의 식별자 변수(id) 값을 USER_ID 컬럼에 저장해라.
	@JoinColumn(name = "USER_ID")
	private User user;
	
	
}




