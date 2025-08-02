package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// BOARD 테이블의 하나의 ROW와 매핑되는 클래스
@Data
@Entity
@Table(name = "USERS")
public class User { 
	@Id
	private String username; // 아이디는 반드시 username으로 처리해야 한다.
	private String password; // 비밀번호
	private String name; 	 // 사용자 이름
	private String role; 	 // 권한
}
