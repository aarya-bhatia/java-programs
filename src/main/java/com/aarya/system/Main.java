package com.aarya.system;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Enter command: ");
		try (Scanner sc = new Scanner(System.in)) {
			String command = sc.nextLine();
			Process process = Runtime.getRuntime().exec(command);
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		}
		catch(IOException e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
