package com.aarya.Playground;

import java.io.*;

public class Main {
	
	public static void serializePosition(Position[] positions) {
		try {
			FileOutputStream fout = new FileOutputStream("/tmp/position.ser");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			for(Position p : positions) {
				out.writeObject(p);
			}
			out.close();
			fout.close();
			System.out.println("serialized data is saved in /tmp/position.ser");
		} catch(IOException e) {
			System.err.println(e.getLocalizedMessage());
		}
	}
	
	public static Position[] deserializePositions() {
		Position p[] = new Position[2];
		try {
	         FileInputStream fileIn = new FileInputStream("/tmp/position.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);

	         p[0] = (Position) in.readObject();
	         p[1] = (Position) in.readObject();
	         
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      } catch (ClassNotFoundException c) {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	      }
		return p;
	}
	
	public static void main(String args[]) {
		
		//serializePosition(new Position[]{new Position(2,4), new Position(3, 5)});
		
		Position[] p = deserializePositions();
		
		for(Position pos : p) {
			if(pos != null) System.out.println(pos.x + " " + pos.y);
		}
	}
}
