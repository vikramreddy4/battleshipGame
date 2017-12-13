package com.isp.example;

import java.util.HashSet;
import java.util.Set;

public class Ship {
	
	private Set<Location> locations;
	private String direction;
	private int length;
	private int headX;
	private int headY;

	public Ship(String direction, int length, int headX, int headY) {
		this.direction = direction;
		this.length = length;
		this.headX = headX;
		this.headY = headY;
	}
	
	public boolean setupLocations() {
		if(locations == null) {
			locations = new HashSet<Location>();
		}
		for(int i = 0, x = headX,y=headY;i<length;i++) {
			if(i > 0) {
				if(direction == "LEFT") {
					y++;
				}else if(direction == "RIGHT") {
					y--;
				}else if(direction == "TOP") {
					x++;
				}else if(direction == "BOTTOM") {
					x--;
				}
			}
			Location location = new Location(x,y);
			if(location.isValid()) {
				locations.add(location);
			}else {
				return false;
			}
		}
		System.out.println("Setup complete for Ship with locations "+locations.toString());
		return true;
	}
	
	public boolean hit(int x, int y) {
		if(locations != null) {
			for(Location location : locations) {
				if(location.getX() == x && location.getY() == y) {
					if(!location.isHit()) {
						location.markAsHit();
					}
					return true;
				}
			}
		}
		return false;
	}

	public boolean isShipCompletelyHit() {
		if(locations != null) {
			for(Location location : locations) {
				if(!location.isHit()) {
					return false;
				}
			}
		}
		return true;
	}

	public double getHitPercentage() {
		int totalLocations = locations.size();
		int hitLocations = 0;
		for(Location location : locations) {
			if(location.isHit()) {
				hitLocations++;
			}
		}
		return ((hitLocations*100) / totalLocations);
	}
	
	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getHeadX() {
		return headX;
	}

	public void setHeadX(int headX) {
		this.headX = headX;
	}

	public int getHeadY() {
		return headY;
	}

	public void setHeadY(int headY) {
		this.headY = headY;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
}
