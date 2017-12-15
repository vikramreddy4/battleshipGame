package com.isp.exercise;

import java.util.Random;

public class GameUtil {

	private static int LOCATION_MAX_X = 10;
	private static int LOCATION_MAX_Y = 10;

	public static String DIRECTION_LEFT = "LEFT";
	public static String DIRECTION_BOTTOM = "BOTTOM";
	public static String DIRECTION_TOP = "TOP";
	public static String DIRECTION_RIGHT = "RIGHT";
	private static final String REGEX_1_TO_9 = "[1-9]{1}[A-J]{1}";
	private static final String REGEX_10 = "[1]{1}[0]{1}[A-J]{1}";

	public static boolean isValidLocation(int x, int y) {
		if (x > LOCATION_MAX_X || x < 1 || y > LOCATION_MAX_Y || y < 1) {
			return false;
		}
		return true;
	}

	public static boolean isValidInput(String input) {
		if(input == null) {
			return false;
		}
		return (input.toUpperCase().matches(REGEX_1_TO_9) || input.matches(REGEX_10));
	}
	
	public static int[] extractCoordinates(String input) {
		int[] coordinates = new int[2];
		if(input.matches(REGEX_10)) {
			coordinates[0] = Integer.parseInt(input.substring(0, 2));
			coordinates[1] = input.charAt(2)-64;;
		}else {
			coordinates[0] = Integer.parseInt(input.substring(0, 1));
			coordinates[1] = input.charAt(1)-64;;
		}
		return coordinates;
	}

	public static int[] extractRandomCoordinates() {
		int[] coordinates = new int[2];
    	coordinates[0] = new Random().nextInt(10)+1;
    	coordinates[1] = new Random().nextInt(10)+1;
		return coordinates;
	}
}
