package com.rubypaper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.service.BoardService;

// 1. @WebMvcTest는 @Controller와 @RestController 객체만 생성한다.
// 2. @WebMvcTest는 가짜 서블릿 컨테이너(MockMvc)를 모킹한다.
@WebMvcTest
public class BoardControllerTest3 {
	
	// 가짜 서블릿 컨테이너(MockMvc)를 목업한다.
	@Autowired
	private MockMvc mockMvc;
	
	// @MockitoBean은 BoardService 타입의 구현 객체를 자동으로 생성해준다.
	@MockitoBean
	private BoardService boardService;

	@Test
	void testHello() throws Exception {
		// @MockitoBean이 생성해준 가짜 비즈니스 객체의 베소드를 호출하고 결과 데이터를 설정한다.
		when(boardService.hello("gurum")).thenReturn("hello : gurum");
		
		mockMvc.perform(get("/hello.do").param("name", "gurum"))
		.andExpect(status().is(200))
		.andExpect(content().string("hello : gurum"))
		.andDo(print());
	}
	
	@Test
	void testGetBoard() throws Exception {
		// @MockitoBean이 생성해준 가짜 비즈니스 객체의 베소드를 호출하고 결과 데이터를 설정한다.
		Map<String, Object> board = new HashMap<String, Object>();
		board.put("SEQ", 1);
		board.put("WRITER", "gurum");
		when(boardService.getBoard(1)).thenReturn(board);
		
		mockMvc.perform(get("/getBoard.do").param("seq", "1"))
		.andExpect(status().is(200))
		.andExpect(jsonPath("$.WRITER").isNotEmpty())
		.andExpect(jsonPath("$.WRITER").value("gurum"))
		.andDo(print());
	}
}







