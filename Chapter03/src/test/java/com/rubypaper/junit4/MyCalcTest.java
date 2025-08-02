package com.rubypaper.junit4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rubypaper.junit.MyCalc;

public class MyCalcTest {
	private MyCalc calc;

	@Before
	public void setUp() throws Exception {
		calc = new MyCalc(10, 3);
	}

	@After
	public void tearDown() throws Exception {
		calc = null;
	}

	@Test
	public void testPlus() {
		assertEquals(13, calc.plus());
	}

	@Test
	public void testMinus() {
		assertEquals(7, calc.minus());
	}

}
