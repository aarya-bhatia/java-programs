package com.aarya.Playground.bits;

public class BitwiseManipulation {
	public static void run() {
		int x = 5;
		int y = x >> 1;
		int z = x << 1;
		print(x);
		print(y);
		print(z);
		int b = Integer.BYTES;
		System.out.println("bytes in int = " + b);
	}

	public static void print(int n) {
		System.out.println(Integer.toBinaryString(n) + " -> " + n);
	}

	// Method to find the element that occurs only once
	static int lonelyInteger(int arr[]) {
		int result = 0;
		for (int i : arr) {
			result ^= i;
			System.out.println("arr[i]: " + i + " -> " + Integer.toBinaryString(i) + " result: " + result + " -> "
					+ Integer.toBinaryString(result));
		}
		return result;
	}

	public static void main(String args[]) {
		run();
		int arr[] = { 3, 2, 3, 1, 2 };
		System.out.println("The element with single occurrence is " + lonelyInteger(arr));
	}
}
