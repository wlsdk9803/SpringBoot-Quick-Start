package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity // 필수
//@Table(name = "BOARD") // 옵션 : 엔티티 클래스 이름과 테이블 이름이 같으면 삭제 가능
//@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
//					sequenceName = "BOARD_SEQ",
//					initialValue = 1,
//					allocationSize = 1)
//@TableGenerator(name = "BOARD_SEQ_GENERATOR",
//					table = "SEQUENCE_TABLE",
//					pkColumnName = "TABLE_NAME",
//					pkColumnValue = "BOARED",
//					valueColumnName = "NEXT_VALUE",
//					initialValue = 0,
//					allocationSize = 1)

public class Board {
	@Id // 식별자 변수 // 필수 (seq 변수가 PK 칼럼과 매핑된다는 설정)
	@GeneratedValue(strategy = GenerationType.AUTO) // 옵션 : seq 변수에 1부터 1씩 자동으로 증가된 값을 할당하는 설정
	private int seq;
	private String title;
	
	@Column(updatable = false)
	private String writer;
	private String content;
	
	@Column(name = "REG_DATE", updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date regDate = new Date();
	
	private int cnt = 0;
	
	// searchKeyword 변수는 매핑에서 제외
	@Transient
	private String searchKeyword;
}
