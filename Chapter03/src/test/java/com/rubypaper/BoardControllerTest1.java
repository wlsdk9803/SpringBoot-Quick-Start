package com.rubypaper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// 1. @WebMvcTest는 @Controller와 @RestController 객체만 생성한다.
// 2. @WebMvcTest는 가짜 서블릿 컨테이너(MockMvc)를 모킹한다.
@WebMvcTest
public class BoardControllerTest1 {
	
	// 가짜 서블릿 컨테이너(MockMvc)를 목업한다.
	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHello() throws Exception {
		// HTTP(http://localhost:8080/hello.do?name=gurum) 요청을 가짜 서블릿 컨테이너에게 전달한다.
		mockMvc.perform(get("/hello.do").param("name", "gurum"))
		
		// HTTP 응답 결과를 검증한다.
		.andExpect(status().is(200))
		.andExpect(content().string("hello : gurum"))
		.andDo(print());
	}
}







