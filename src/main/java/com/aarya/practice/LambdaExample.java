package com.aarya.practice;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.*;

public class LambdaExample {

	@FunctionalInterface
	static interface Numbers {
		public int run(int x, int y);
	}

	public void addNum() {
		Numbers n = (x, y) -> x + y;
		System.out.println(n.run(2, 4));
	}	

	public void listConsumer() {
		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(9);
		l.add(14);
		l.add(56);

		int sum = 0;
		Consumer<Integer> consumer = x -> {
			System.out.println(x/2);
		};

		l.forEach(consumer);
	}

	public void streams() {
		IntStream.range(1,5).map(x -> x+1).forEach(x -> System.out.println(x));
	}

	public static void main(String args[]) {
		LambdaExample le = new LambdaExample();
		//le.listConsumer();
		le.streams();
	}
}


