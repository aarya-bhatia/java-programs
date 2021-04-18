package com.aarya.practice;

/** stack data structure */
public class Stack<E> {
	
	/** Generic array to store items in stack */
	Object[] data;
	/** Position of pointer in stack */
	int top;
	/** Max size of stack */
	int len;

	/** constructor
	 * @param l max size of stack
	 */
	public Stack(int l) {
		len = l;
		data = new Object[l];
		top = -1;
	}

	/** default constructor
	 * initializes stack with size 10
	 */
	public Stack() {
		this(10);
	}

	/** @return number of items in stack
	 */
	public int size() {
		return 1 + top;
	}

	/** insert value in stack
	 * @param val value to insert
	 */
	public void push(E val) {
		if(top >= len - 1) {
			throw new IllegalArgumentException("stack is full!");
		}
		data[++top] = (Object) val;
		System.out.println("insert success");
	}

	/** remove top items from stack
	 * @return item at top of stack
	 */
	
}

