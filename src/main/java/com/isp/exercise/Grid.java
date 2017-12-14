package com.isp.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
	
	private List<Ship> ships;
	private Set<Location> unoccupiedLocations;

	public boolean setupShips(String[] directions, int[] headXCoordinates, int[] headYCoordinates, int[] shipSizes) {
		Set<Location> shipOccupiedLocations = new HashSet<Location>();
		if(ships == null) {
			ships = new ArrayList<Ship>();
		}
		if(headXCoordinates.length == 0 || headYCoordinates.length == 0 || shipSizes.length == 0 
				|| headXCoordinates.length != shipSizes.length || headYCoordinates.length != shipSizes.length) {
			return false;
		}
		for(int i = 0; i < shipSizes.length;i++) {
			Ship ship = new Ship(directions[i], shipSizes[i], headXCoordinates[i], headYCoordinates[i]);
			if(!ship.setupLocations(shipOccupiedLocations)) {
				return false;
			}
			shipOccupiedLocations.addAll(ship.getLocations());
			ships.add(ship);
		}
		return true;
	}

	public void hit(int x, int y) {
		boolean shipWasHit = false;
		for(Ship ship : ships) {
			if(ship.hit(x, y)) {
				shipWasHit = true;
				break;
			}
		}
		if(!shipWasHit) {
			if(unoccupiedLocations == null) {
				unoccupiedLocations = new HashSet<Location>();
			}
			unoccupiedLocations.add(new Location(x, y, true));
		}
	}
	
	public boolean areShipsCompletelyHit() {
		for(Ship ship : ships) {
			if(!ship.isShipCompletelyHit()) {
				return false;
			}
		}
		return true;
	}
	
	public void printHitPercentageOfAllShips() {
		System.out.println("Hit % for ships : ");
		for(Ship ship : ships) {
			System.out.print(ship.getHitPercentage());
			System.out.print(" , ");
		}
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public Set<Location> getUnoccupiedLocations() {
		return unoccupiedLocations;
	}

	public void setUnoccupiedLocations(Set<Location> unoccupiedLocations) {
		this.unoccupiedLocations = unoccupiedLocations;
	}
	
	public void addUnoccupiedLocation(Location location) {
		if(unoccupiedLocations == null) {
			unoccupiedLocations = new HashSet<Location>();
		}
		unoccupiedLocations.add(location);
	}
}