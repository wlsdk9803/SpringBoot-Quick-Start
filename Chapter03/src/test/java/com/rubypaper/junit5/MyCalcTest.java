package com.rubypaper.junit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rubypaper.junit.MyCalc;

class MyCalcTest {
	private MyCalc calc;

	@BeforeEach
	void setUp() throws Exception {
		calc = new MyCalc(10, 3);
	}

	@AfterEach
	void tearDown() throws Exception {
		calc = null;
	}

	@Test
	void testPlus() {
		assertEquals(13, calc.plus());
	}

	@Test
	void testMinus() {
		assertEquals(7, calc.minus());
	}

}
