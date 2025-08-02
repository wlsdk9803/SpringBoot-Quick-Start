package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
//	@GeneratedValue // 정수형 변수에만 사용 가능
	private String id;
	private String password;
	private String name;
	private String role;
}
