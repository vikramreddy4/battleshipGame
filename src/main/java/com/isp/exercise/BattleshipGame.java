package com.isp.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BattleshipGame {

	public static Scanner reader = new Scanner(System.in);
    private static String[] userShipDirections = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
    private static int[] userShipXCoordinates = {1,3,5,7};
    private static int[] userShipYCoordinates = {1,1,1,1};
    private static int[] userShipSizes = {2,3,4,5};
    
    private static String[] computerShipDirections = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
    private static int[] computerShipXCoordinates = {1,3,5,7};
    private static int[] computerShipYCoordinates = {1,1,1,1};
    private static int[] computerShipSizes = {2,3,4,5};
	
	/**
	 * This 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("BATTLESHIP GAME STARTING ...");
        Set<String> generatedNumbers = new HashSet<String>(100);

        Grid userGrid = setUp("USER", userShipDirections, userShipXCoordinates, userShipYCoordinates, userShipSizes);
        Grid computerGrid = setUp("COMPUTER", computerShipDirections, computerShipXCoordinates, computerShipYCoordinates, computerShipSizes);
        
        System.out.println("SETUP SUCCESSFULL. Press ENTER to start the Game.");
        reader.nextLine();
        
        while(true) {
            System.out.println("PRESS 'Q' to quit at any stage.");
        	System.out.print("Type (1-10) for the row, (A-J) for the column you want to hit, from 1A to 10J : ");
        	String input = reader.next().toUpperCase();
        	if(input.charAt(0) == 81) {
            	System.out.print("Stopping the GAME.");
        		System.exit(1);
        	}
        	if(GameUtil.isValidInput(input)) {
            	int[] coordinates = GameUtil.extractCoordinates(input);
            	System.out.println("###########################################################################################################");
            	System.out.print(String.format("Hitting the coordinates %s %s on Computer's Grid", coordinates[0], coordinates[1]));
        		if(GameUtil.isValidLocation(coordinates[0], coordinates[1])) {
        			if(recordHit(computerGrid, coordinates)) {
                    	System.out.println("Wow ! You won the game.");
                    	System.out.println("Stopping the GAME.");
                		System.exit(1);
        			}
                	
                	System.out.println("----------------------------------------------------------------------------------------------------------");
                	int[] coordinatesRamdom = GameUtil.extractRandomCoordinates();
                	while(generatedNumbers.size() < 100 && generatedNumbers.contains(coordinatesRamdom[0]+"-"+coordinatesRamdom[1])) {
                		// Computer should not take already taken coordinate, as per requirement.
                		coordinatesRamdom = GameUtil.extractRandomCoordinates();
                	}
                	generatedNumbers.add(coordinatesRamdom[0]+"-"+coordinatesRamdom[1]);
                	System.out.print(String.format("Hitting the random picked coordinates %s %s on User's Grid", coordinatesRamdom[0], coordinatesRamdom[1]));
        			if(recordHit(userGrid, coordinatesRamdom)) {
                    	System.out.println("Oh No ! You lost, Computer won the game.");
                    	System.out.println("Stopping the GAME.");
                		System.exit(1);
        			}
        		}
            	System.out.println("###########################################################################################################");
    		}else {
    			System.out.println(String.format("%s is an Invalid value !!!! Please enter a valid one.", input));
    		}
        }
	}

	private static Grid setUp(String name, String[] shipDirections, int[] shipHeadXCoordinates, int[] shipHeadYCoordinates, int[] shipSizes) {
		System.out.println(String.format("SETTING UP %s ...", name));
        Grid grid = new Grid(name);
        if(!grid.setupShips(shipDirections, shipHeadXCoordinates, shipHeadYCoordinates, shipSizes)) {
        	System.out.println(String.format("Error while setting up data for %s. Stopping the Game.",name));
    		System.exit(1);
        }
        return grid;
	}

	private static boolean recordHit(Grid grid, int[] coordinates) {
		try {
			if(grid.hit(coordinates[0], coordinates[1])) {
				return grid.areShipsCompletelyHit();
			}
		} finally {
        	grid.printHitPercentageOfAllShips();
		}
		return false;
	}
}
