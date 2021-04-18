package com.aarya.practice;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTest {

	/** dummy data to use for testing stack */
	Integer x1 = Integer.valueOf(1);
	Integer x2 = Integer.valueOf(2);
	Integer x3 = Integer.valueOf(5);
	Integer x4 = Integer.valueOf(10);
	Integer x5 = Integer.valueOf(20);

	/* stack to run test on */
	Stack<Integer> s;

	@Before
	public void initStack() {
		s = new Stack<Integer>();
	}

	@Test
	public void testEmpty() {
		// expected value is 0
		// actual value is s.size()
		assertEquals("empty stack size", 0, s.size());

		//s.pop();
		//assertEquals("pop on empty stack", 0, s.size());
	}

	@Test
	public void testSizeAfterInsert() {
		s.push(x1);
		s.push(x2);
		assertEquals("size should be 2", 2, s.size());
	}

	/* Start test */
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("StackTest");
	}

}
