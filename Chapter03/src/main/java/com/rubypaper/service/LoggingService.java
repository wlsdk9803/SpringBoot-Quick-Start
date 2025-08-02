package com.rubypaper.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingService implements ApplicationRunner {
	
	// Logger 객체를 획득한다.
	private Logger logger = LoggerFactory.getLogger(LoggingService.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// Logger 객체를 이용하여 다양한 레벨의 로그를 출력한다.
		logger.trace("--------trace 레벨 로그");
		logger.debug("--------debug 레벨 로그");
		logger.info("--------info 레벨 로그");
		logger.warn("--------warn 레벨 로그");
		logger.error("--------error 레벨 로그");

	}

}
