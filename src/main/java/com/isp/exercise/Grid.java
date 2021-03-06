package com.isp.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grid {
	
	private String name;
	private List<Ship> ships;

	public Grid(String name) {
		this.name = name;
	}
	
	/**
	 * Set up the ships for the Grid.
	 * @param directions
	 * @param headXCoordinates
	 * @param headYCoordinates
	 * @param shipSizes
	 * @return
	 */
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

	/**
	 * Check if the ship is hit.
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean hit(int x, int y) {
		for(Ship ship : ships) {
			if(ship.hit(x, y)) {
				System.out.println(String.format(" ==>> %s's Ship was HIT !!!!!!!!!!!!!!!!", name));
				return true;
			}
		}
		System.out.println(" ==>> MISSED.");
		return false;
	}
	
	/**
	 * Check if all the ships are hit on this Grid.
	 * @return
	 */
	public boolean areShipsCompletelyHit() {
		for(Ship ship : ships) {
			if(!ship.isShipCompletelyHit()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Get the percentage hit for each ship on the Grid board. 
	 */
	public void printHitPercentageOfAllShips() {
		System.out.print(String.format("Hit percentage for ships on %s's grid : ", name));
		for(Ship ship : ships) {
			System.out.print(ship.getHitPercentage());
			System.out.print(" , ");
		}
		System.out.println("");
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}