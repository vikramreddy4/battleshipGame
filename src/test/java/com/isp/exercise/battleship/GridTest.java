package com.isp.exercise.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.isp.exercise.GameUtil;
import com.isp.exercise.Grid;
import com.isp.exercise.Ship;

public class GridTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_Grid_Ships_Overlapped_Locations() throws Exception {
	    String[] directions = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
	    int[] xCoordinates = {1,3,3,7};
	    int[] yCoordinates = {1,1,1,1};
	    int[] sizes = {2,3,4,5};
	    
	    Grid grid = new Grid("");
	    Assert.assertFalse(grid.setupShips(directions, xCoordinates, yCoordinates, sizes));
	}

	@Test
	public void test_Grid_Ships_Count() throws Exception {
	    String[] directions = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
	    int[] xCoordinates = {1,3,5,7};
	    int[] yCoordinates = {1,1,1,1};
	    int[] sizes = {2,3,4,5};
	    
	    Grid grid = new Grid("");
	    Assert.assertTrue(grid.setupShips(directions, xCoordinates, yCoordinates, sizes));
		Assert.assertTrue(grid != null);
		Assert.assertTrue(grid.getShips() != null);
		Assert.assertTrue(grid.getShips().size() == sizes.length);
	}

	@Test
	public void test_Grid_Ships_Hit_Zero_Percentage() throws Exception {
	    String[] directions = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
	    int[] xCoordinates = {1,3,5,7};
	    int[] yCoordinates = {1,1,1,1};
	    int[] sizes = {2,3,4,5};
	    
	    Grid grid = new Grid("");
	    Assert.assertTrue(grid.setupShips(directions, xCoordinates, yCoordinates, sizes));
		Assert.assertTrue(grid != null);
		Assert.assertTrue(grid.getShips() != null);
		Assert.assertTrue(grid.getShips().size() == sizes.length);
		for(Ship ship : grid.getShips()) {
			Assert.assertTrue(ship.getHitPercentage() == 0);
		}
	}

	@Test
	public void test_Grid_Ships_Hit_Greater_Than_Zero_Percentage() throws Exception {
	    String[] directions = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
	    int[] xCoordinates = {1,3,5,7};
	    int[] yCoordinates = {1,1,1,1};
	    int[] sizes = {2,3,4,5};
	    
	    Grid grid = new Grid("");
	    Assert.assertTrue(grid.setupShips(directions, xCoordinates, yCoordinates, sizes));
		Assert.assertTrue(grid != null);
		Assert.assertTrue(grid.getShips() != null);
		Assert.assertTrue(grid.getShips().size() == sizes.length);
		grid.hit(1, 1);
		grid.hit(3, 1);
		grid.hit(5, 1);
		grid.hit(7, 1);
		for(Ship ship : grid.getShips()) {
			Assert.assertTrue(ship.getHitPercentage() > 0);
		}
	}

	@Test
	public void test_Grid_Ships_Hit_Hundred_Percentage() throws Exception {
	    String[] directions = {GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT,GameUtil.DIRECTION_LEFT};
	    int[] xCoordinates = {1,3,5,7};
	    int[] yCoordinates = {1,1,1,1};
	    int[] sizes = {2,3,4,5};
	    
	    Grid grid = new Grid("");
	    Assert.assertTrue(grid.setupShips(directions, xCoordinates, yCoordinates, sizes));
		Assert.assertTrue(grid != null);
		Assert.assertTrue(grid.getShips() != null);
		Assert.assertTrue(grid.getShips().size() == sizes.length);
		grid.hit(1, 1);
		grid.hit(1, 2);
		
		grid.hit(3, 1);
		grid.hit(3, 2);
		grid.hit(3, 3);

		grid.hit(5, 1);
		grid.hit(5, 2);
		grid.hit(5, 3);
		grid.hit(5, 4);
		
		grid.hit(7, 1);
		grid.hit(7, 2);
		grid.hit(7, 3);
		grid.hit(7, 4);
		grid.hit(7, 5);
		for(Ship ship : grid.getShips()) {
			Assert.assertTrue(ship.getHitPercentage() == 100);
		}
	}
}
