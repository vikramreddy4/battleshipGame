package com.isp.example;

import java.util.Random;
import java.util.Scanner;

public class BattleshipGame {

	public static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("BATTLESHIP GAME STARTING ...");  
        
        String[] userShipDirections = {"LEFT","LEFT","LEFT","LEFT"};
        int[] userShipXCoordinates = {1,3,5,7};
        int[] userShipYCoordinates = {1,1,1,1};
        int[] userShipSizes = {2,3,4,5};
        
        String[] computerShipDirections = {"LEFT","LEFT","LEFT","LEFT"};
        int[] computerShipXCoordinates = {1,3,5,7};
        int[] computerShipYCoordinates = {1,1,1,1};
        int[] computerShipSizes = {2,3,4,5};

		System.out.println("SETTING UP USER ...");  
        Grid userGrid = new Grid();
        userGrid.setupShips(userShipDirections, userShipXCoordinates, userShipYCoordinates, userShipSizes);
        
		System.out.println("SETTING UP COMPUTER ...");  
        Grid computerGrid = new Grid();
        computerGrid.setupShips(computerShipDirections, computerShipXCoordinates, computerShipYCoordinates, computerShipSizes);
        
        System.out.println("SETUP SUCCESSFULL. PRESS 'Q' to quit at any stage.");
        reader.nextLine();
        reader.nextLine();
        System.out.println("\nCOMPUTER GRID (FOR DEBUG)...");
        
        while(true) {
        	System.out.print("Type (1-10) for the row you want to hit : ");
        	String xUserCoordinateChar = reader.next().toUpperCase();
        	if(xUserCoordinateChar == "Q") {
            	System.out.print("Stopping the GAME.");
        		System.exit(1);
        	}
        	int xUserCoordinate = Integer.parseInt(xUserCoordinateChar);
        	if(xUserCoordinate < 1 || xUserCoordinate > 10) {
        		continue;
        	}
        	System.out.print("Type (A-J) for the column you want to hit : ");
        	String yUserCoordinateChar = reader.next().toUpperCase();
        	if(yUserCoordinateChar.toUpperCase() == "Q") {
            	System.out.print("Stopping the GAME.");
        		System.exit(1);
        	}
        	int yUserCoordinate = yUserCoordinateChar.charAt(0)-64;
        	System.out.print(String.format("Hitting the coordinates %s %s on Computer's Grid", xUserCoordinate, yUserCoordinate));
        	computerGrid.hit(xUserCoordinate, yUserCoordinate);
        	computerGrid.printHitPercentageOfAllShips();
        	if(computerGrid.areShipsCompletelyHit()) {
            	System.out.print("User won the game.");
            	System.out.print("Stopping the GAME.");
        		System.exit(1);
        	}
        	int xComputerCoordinate = new Random().nextInt(10)+1;
        	int yComputerCoordinate = new Random().nextInt(10)+1;
        	System.out.print(String.format("Hitting the random picked coordinates %s %s on User's Grid", xComputerCoordinate, yComputerCoordinate));
        	userGrid.hit(xComputerCoordinate, yComputerCoordinate);
        	userGrid.printHitPercentageOfAllShips();
        	if(userGrid.areShipsCompletelyHit()) {
            	System.out.print("Computer won the game.");
            	System.out.print("Stopping the GAME.");
        		System.exit(1);
        	}
        }
	}

}
