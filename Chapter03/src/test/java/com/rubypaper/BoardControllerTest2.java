package com.rubypaper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.rubypaper.domain.BoardVO;

// @SpringBootTest의 webEnvironment 속성을 이용하면 정상적으로 톰캣 서버를 구동할 수 있다.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BoardControllerTest2 {
	
	// 가짜 브라우저 객체
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void testHello() throws Exception {
		String result = restTemplate.getForObject("/hello.do?name=gurum", String.class);
		assertEquals("hello : gurum", result);
	}
	
	@Test
	void testGetBoard() throws Exception {
		BoardVO result = restTemplate.getForObject("/getBoard.do?seq=1", BoardVO.class);
		assertNotNull(result);
		assertEquals("테스터", result.getWriter());
	}
	
	@Test
	void testGetBoardList() throws Exception {
		List result = restTemplate.getForObject("/getBoardList.do", List.class);
		assertEquals(5, result.size());
	}
}







