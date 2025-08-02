package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "boardList")
@Entity
@Table(name = "USERS")
public class User {
	@Id
	private String id;
	private String password;
	private String name;
	private String role;
	
	// One(User)객체를 검색할 때, 연관된 Many(Board) 객체도 같이 검색해라.
	// 양방향 매핑에서는 연관관계의 주인이 아닌 쪽 변수에 mappedBy를 설정한다.
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Board> boardList = new ArrayList<Board>();
}




