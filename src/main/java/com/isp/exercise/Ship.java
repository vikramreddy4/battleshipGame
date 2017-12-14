package com.isp.exercise;

import java.util.HashSet;
import java.util.Set;

public class Ship {
	
	public static String DIRECTION_LEFT = "LEFT";
	public static String DIRECTION_BOTTOM = "BOTTOM";
	public static String DIRECTION_TOP = "TOP";
	public static String DIRECTION_RIGHT = "RIGHT";
	
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
	
	public boolean setupLocations(Set<Location> otherShipsOccupiedLocations) {
		if(locations == null) {
			locations = new HashSet<Location>();
		}
		if(direction == null) {
			direction = DIRECTION_LEFT;
		}
		if(length == 0 || headX < 1 || headX > 10 || headY < 1 || headY > 10) {
			return false;
		}
		for(int i = 0, x = headX,y=headY;i<length;i++) {
			if(i > 0) {
				if(direction == DIRECTION_LEFT) {
					y++;
				}else if(direction == DIRECTION_RIGHT) {
					y--;
				}else if(direction == DIRECTION_TOP) {
					x++;
				}else if(direction == DIRECTION_BOTTOM) {
					x--;
				}else {
					// soft validation for unknown / unrecognized value
					direction = DIRECTION_LEFT;
					y++;
				}
			}
			Location location = new Location(x,y);
			if(!location.isValid()) {
				System.out.println("Invalid location, please check location properties for location : "+location.toString());
				return false;
			}
			if(otherShipsOccupiedLocations.contains(location)) {
				System.out.println("Invalid location, This location is already occupied by another Ship : "+location.toString());
				return false;
			}
			locations.add(location);
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
