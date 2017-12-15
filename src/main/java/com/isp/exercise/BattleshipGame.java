package com.isp.exercise;

import java.util.Scanner;

public class BattleshipGame {

	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("BATTLESHIP GAME STARTING ...");  
        
        String[] userShipDirections = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
        int[] userShipXCoordinates = {1,3,5,7};
        int[] userShipYCoordinates = {1,1,1,1};
        int[] userShipSizes = {2,3,4,5};
        
        String[] computerShipDirections = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
        int[] computerShipXCoordinates = {1,3,5,7};
        int[] computerShipYCoordinates = {1,1,1,1};
        int[] computerShipSizes = {2,3,4,5};

		System.out.println("SETTING UP USER ...");  
        Grid userGrid = new Grid();
        userGrid.setupShips(userShipDirections, userShipXCoordinates, userShipYCoordinates, userShipSizes);
        
		System.out.println("SETTING UP COMPUTER ...");  
        Grid computerGrid = new Grid();
        computerGrid.setupShips(computerShipDirections, computerShipXCoordinates, computerShipYCoordinates, computerShipSizes);
        
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
            	System.out.println(String.format("Hitting the coordinates %s %s on Computer's Grid", coordinates[0], coordinates[1]));
        		if(GameUtil.isValidLocation(coordinates[0], coordinates[1])) {
                	if(computerGrid.hit(coordinates[0], coordinates[1])) {
                    	if(computerGrid.areShipsCompletelyHit()) {
                        	System.out.println("Wow ! You won the game.");
                        	System.out.println("Stopping the GAME.");
                    		System.exit(1);
                    	}
                	}
                	computerGrid.printHitPercentageOfAllShips();
                	int[] coordinatesRamdom = GameUtil.extractRandomCoordinates();
                	System.out.println(String.format("Hitting the random picked coordinates %s %s on User's Grid", coordinatesRamdom[0], coordinatesRamdom[1]));
                	if(userGrid.hit(coordinatesRamdom[0], coordinatesRamdom[1])) {
                    	if(userGrid.areShipsCompletelyHit()) {
                        	System.out.println("Oh No ! You lost, Computer won the game.");
                        	System.out.println("Stopping the GAME.");
                    		System.exit(1);
                    	}
                	}
                	userGrid.printHitPercentageOfAllShips();
        		}
    		}else {
    			System.out.println(String.format("%s is an Invalid value !!!! Please enter a valid one.", input));
    		}
        }
	}

}
