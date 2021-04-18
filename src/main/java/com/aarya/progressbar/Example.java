package com.aarya.progressbar;

public class Example {

	public static void main(String args[]){
		progressBar();
	}
	
	public static void progressBar() {

		int val = 0;

		while(val <= 100) {
			String show = String.valueOf(val) + " % ";
			System.out.print("\r" + "Loading: " + show);
			val++;	
			try{Thread.sleep(10);}catch(Exception e){}
		}
	}

}
