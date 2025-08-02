package com.rubypaper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import com.rubypaper.controller.BoardController;

// @SpringBootTest : 모든 종류의 객체(@Controller, @Service, @Repository)를 생성한다.
@SpringBootTest(properties = {"author.name=HONG", 
		                      "author.nation=KOREA"},
				classes = {BoardController.class})
class PropertiesTest {
	
//	@Value("${author.name}")
//	private String name;	
//	
//	@Value("${author.age}")
//	private int age;
	
	@Autowired
	private Environment env;

	@Test
	void testMethod() {
		System.out.println("이름 : " + env.getProperty("author.name"));
		System.out.println("나이 : " + env.getProperty("author.age"));
		System.out.println("국적 : " + env.getProperty("author.nation"));
	}

}





