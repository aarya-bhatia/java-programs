package com.aarya.networking;

import java.io.DataOutputStream;
import java.net.Socket;

public class MyClient {
	public static void main(String args[]) {
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello world!");
			dout.flush();
			dout.close();
		} catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
