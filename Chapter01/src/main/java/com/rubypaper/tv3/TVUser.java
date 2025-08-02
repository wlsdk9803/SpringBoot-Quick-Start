package com.rubypaper.tv3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 스프링 컨테이너를 생성한다.
		AnnotationConfigApplicationContext container = 
			new AnnotationConfigApplicationContext(TVConfiguration.class);
		
		// 스프링 컨테이너로부터 필요한 객체를 획득한다.
		TV tv = (TV) container.getBean("tv");
		tv.powerOn();
		tv.volumeDown();
		tv.volumeUp();
		tv.powerOff();
	}

}
