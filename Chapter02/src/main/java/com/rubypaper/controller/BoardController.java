package com.rubypaper.controller;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
}
