package com.isp.exercise;

public class Location {
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
		return GameUtil.isValidLocation(x, y);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Location) {
			return (this.x == (((Location) o).getX()) && this.y == (((Location) o).getY()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Integer.parseInt(Integer.toString(x) + Integer.toString(y));
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