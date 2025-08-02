package com.test;

import org.springframework.stereotype.Component;

@Component("test")
public class TestBean {
	public TestBean() {
		System.out.println("===> TestBean 생성");
	}
}
