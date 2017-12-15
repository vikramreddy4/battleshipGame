package com.isp.exercise.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.isp.exercise.GameUtil;

public class GameUtilTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test	public void testValidLocation_X_Y_1_1() throws Exception { Assert.assertTrue(GameUtil.isValidLocation(1,1));	}
	@Test	public void testValidLocation_X_Y_10_10() throws Exception { Assert.assertTrue(GameUtil.isValidLocation(10,10)); }
	@Test	public void testValidLocation_X_Y_5_5() throws Exception { Assert.assertTrue(GameUtil.isValidLocation(5,5));	}

	@Test	public void testValidLocation_X_Y_0_0() throws Exception { Assert.assertFalse(GameUtil.isValidLocation(0,0)); }
	@Test	public void testValidLocation_X_Y_0_1() throws Exception { Assert.assertFalse(GameUtil.isValidLocation(0,1)); }
	@Test	public void testValidLocation_X_Y_1_0() throws Exception { Assert.assertFalse(GameUtil.isValidLocation(1,0)); }
	@Test	public void testValidLocation_X_Y_10_11() throws Exception { Assert.assertFalse(GameUtil.isValidLocation(10,11)); }
	@Test	public void testValidLocation_X_Y_11_10() throws Exception { Assert.assertFalse(GameUtil.isValidLocation(11,10)); }
	
	@Test	public void testValidInput_1_A() throws Exception { Assert.assertTrue(GameUtil.isValidInput("1A")); }
	@Test	public void testValidInput_1_a() throws Exception { Assert.assertTrue(GameUtil.isValidInput("1a")); }
	@Test	public void testValidInput_2_B() throws Exception { Assert.assertTrue(GameUtil.isValidInput("2B")); }
	@Test	public void testValidInput_5_e() throws Exception { Assert.assertTrue(GameUtil.isValidInput("5e")); }
	@Test	public void testValidInput_9_I() throws Exception { Assert.assertTrue(GameUtil.isValidInput("9I")); }
	@Test	public void testValidInput_10_J() throws Exception { Assert.assertTrue(GameUtil.isValidInput("10J")); }

	@Test	public void testValidInput_11_A() throws Exception { Assert.assertFalse(GameUtil.isValidInput("11A")); }
	@Test	public void testValidInput_1_K() throws Exception { Assert.assertFalse(GameUtil.isValidInput("1K")); }

	@Test
	public void testExtractCoordinates_1_A() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("1A");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 1);
		Assert.assertTrue(coordinates[1] == 1);
	}

	@Test
	public void testExtractCoordinates_2_B() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("2B");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 2);
		Assert.assertTrue(coordinates[1] == 2);
	}

	@Test
	public void testExtractCoordinates_5_E() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("5E");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 5);
		Assert.assertTrue(coordinates[1] == 5);
	}

	@Test
	public void testExtractCoordinates_9_I() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("9I");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 9);
		Assert.assertTrue(coordinates[1] == 9);
	}

	@Test
	public void testExtractCoordinates_10_A() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("10A");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 10);
		Assert.assertTrue(coordinates[1] == 1);
	}
	
	@Test
	public void testExtractCoordinates_10_E() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("10E");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 10);
		Assert.assertTrue(coordinates[1] == 5);
	}
	
	@Test
	public void testExtractCoordinates_10_J() throws Exception {
		int[] coordinates = GameUtil.extractCoordinates("10J");
		Assert.assertTrue(coordinates.length == 2);
		Assert.assertTrue(coordinates[0] == 10);
		Assert.assertTrue(coordinates[1] == 10);
	}
}
