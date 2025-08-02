package com.rubypaper.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubypaper.domain.User;
import com.rubypaper.persistence.UserRepository;


@Service
public class UserServiceImpl implements UserService {
	
	// 스프링이 자동으로 생성해주는 BoardRepository 타입의 객체 주입
	@Autowired
	private UserRepository userRepository;
	
	// 회원 상세 조회
	public User getUser(User user) {
		Optional<User> findObject = userRepository.findById(user.getUsername());
		if(findObject.isPresent()) {
			return findObject.get();
		} else {
			// 아이디(username)에 해당하는 User 객체를 검색하지 못한 경우 null을 리턴
			return null;
		}
	}
}
