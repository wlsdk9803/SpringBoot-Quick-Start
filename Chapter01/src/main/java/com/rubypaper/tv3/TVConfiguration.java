package com.rubypaper.tv3;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.rubypaper.tv3", "com.test"})
public class TVConfiguration {
	public TVConfiguration() {
		System.out.println("===> TVConfiguration 생성");
	}

//	@Bean
//	TV tv() {
//		return new SamsungTV();
//	}
//	
//	@Bean
//	Speaker speaker() {
//		return new SonySpeaker();
//	}
}







