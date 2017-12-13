package com.isp.example;

public class Location {
	private static int MAX_X = 10;
	private static int MAX_Y = 10;
	
	private int x;
	private int y;
	private boolean hit;
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Location(int x, int y, boolean hit) {
		this.x = x;
		this.y = y;
		this.hit = hit;
	}

	public boolean isValid() {
		if(x > MAX_X || x < 1 || y > MAX_Y || y < 1) {
			return false;
		}
		return true;
	}
	
	public void markAsHit() {
		this.hit = true;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public boolean isHit() {
		return hit;
	}
	public void setHit(boolean hit) {
		this.hit = hit;
	}

	@Override
	public String toString() {
		return "Location [x=" + x + ", y=" + y + ", hit=" + hit + "]";
	}
	
}