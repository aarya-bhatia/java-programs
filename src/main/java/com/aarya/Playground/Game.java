package com.aarya.Playground;

class Game {
	Position[] positions;
	int n;
	
	public Game() {
		positions = new Position[10];
		n = 0;
	}
	
	public void add(Position p) {
		if(n < positions.length) {
			positions[n++] = p;
		} else {
			n = 0;
		}
	}
	
	public void print() {
		for(int i = 0; i < n; i++) {
			Position p = positions[i];
			System.out.println("(" + p.x + ", " + p.y + ")-->" + Position.distance(p));
		}
	}
	
	public Position nearest() {
		if(n == 0) { return null; }
		Position min = positions[0];
		for(int i = 0; i < n; i++) {
			if(min.compareTo(positions[i]) > 1) {
				min = positions[i];
			}
		}
		return min;
	}
}