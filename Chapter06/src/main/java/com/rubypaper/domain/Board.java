package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// BOARD 테이블의 하나의 ROW와 매핑되는 클래스
@Data
@Entity
public class Board { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	
	@Column(updatable = false)
	private String writer;
	
	private String content;
	
	@Column(updatable = false)
	private Date regDate = new Date();
	
	@Column(updatable = false)
	private int cnt = 0;
}
