package com.rubypaper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
	@Id
	private String username;
	private String password;
	private String name;
	@Enumerated(EnumType.STRING)
	private Role role;
	private Boolean enabled;
}
