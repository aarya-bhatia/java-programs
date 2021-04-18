package com.aarya.Playground;

class Position implements Comparable<Position>, java.io.Serializable {
	
	protected float x;
	protected float y;
	
	public Position(){
		x = 0;
		y = 0;
	}
	
	public Position(float a, float b){
		x = a;
		y = b;
	}
	
	static float distance(Position p) {
		float dx = (float)Math.pow(p.x, 2);
		float dy =  (float)Math.pow(p.y, 2);
		return (float)Math.sqrt(dx + dy);
	}
	
	@Override
	public int compareTo(Position other) {
		if(distance(this) < distance(other)) {
			return -1;
		} else if(distance(this) > distance(other)) {
			return 1;
		}
		return 0;
	}
	
}