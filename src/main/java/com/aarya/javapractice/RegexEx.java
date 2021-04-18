package com.aarya.javapractice;

import java.util.regex.*;
import java.util.*;

public class RegexEx {
	public static void main(String args[]) {
		String test = "foo=bar&bar=foo&xxx=yyy";
		Pattern p = Pattern.compile("(\\w+)=(\\w+)");
		Matcher m = p.matcher(test);

		while(m.find()) {
			System.out.println(m.group(1) + " " + m.group(2));
		}
	}
}
