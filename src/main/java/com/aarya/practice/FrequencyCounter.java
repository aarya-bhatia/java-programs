package com.aarya.practice;

import java.util.*;
import java.io.*;

/** This class internally maintains a hashmap
 * to count the frequency of characters in a string
 */
public class FrequencyCounter {

	HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	int charCount = 0;

	/** default constructor */
	public FrequencyCounter() {}

	/**
	 * if hashmap contains character,
	 * update the count by one. otherwise,
	 * put it in the map as a new entry.
	 * @param c character to add
	 */
	public void add(char c) {
		Character cw = Character.valueOf(c);
		if(map.containsKey(cw)) {
			Integer count = map.get(cw);
			int nextCount = count.intValue() + 1;
			map.put(cw, Integer.valueOf(nextCount));
		} else {
			map.put(cw, Integer.valueOf(1));
		}
		charCount++;
	}

	/**
	 * method to print the most occuring and
	 * the least occuring character in the map
	 * @return array with both the characters
	 */
	public char[] getSummary() {
		if(charCount == 0) {
			throw new NullPointerException("No enough entries");
		}
		char[] sum = new char[2];
		int[] count = new int[2];
		boolean isemp = true;
		/* iterate through the map */
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			char key = entry.getKey().charValue();
			int value = entry.getValue().intValue();

			/* check if sum[] is empty, fill it with current values */
			if(isemp) {
				isemp = false;
				sum[0] = key;
				sum[1] = key;
				count[0] = value;
				count[1] = value;
				continue;
			}

			/* check if value exceeds max */
			if(value > count[0]) {
				/* update max count and corr char */
				count[0] = value;
				sum[0] = key;
			}
			/* check if value is less than min */
			if(value < count[1]) {
				/* update min count and corr char */
				count[1] = value;
				sum[1] = key;
			}
		}
	       	System.out.println(String.format("The highest occuring character was \"%c\" with a total count of %d. While, the lowest occuring character was \"%c\" with a total count of %d.", sum[0], count[0], sum[1], count[1]));
		return sum;	
	}
}
