package com.isp.exercise.battleship;

import java.util.HashSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.isp.exercise.GameUtil;
import com.isp.exercise.Location;
import com.isp.exercise.Ship;

public class ShipTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test public void test_Ship_With_Length_LEFT_1() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(1); }
	@Test public void test_Ship_With_Length_LEFT_2() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(2); }
	@Test public void test_Ship_With_Length_LEFT_3() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(3); }
	@Test public void test_Ship_With_Length_LEFT_4() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(4); }
	@Test public void test_Ship_With_Length_LEFT_5() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(5); }
	@Test public void test_Ship_With_Length_LEFT_6() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(6); }
	@Test public void test_Ship_With_Length_LEFT_7() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(7); }
	@Test public void test_Ship_With_Length_LEFT_8() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(8); }
	@Test public void test_Ship_With_Length_LEFT_9() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(9); }
	@Test public void test_Ship_With_Length_LEFT_10() throws Exception { testSuccessDirectionLEFT_X_Y_5_1(10); }

	@Test public void test_Ship_With_Length_RIGHT_1() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(1); }
	@Test public void test_Ship_With_Length_RIGHT_2() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(2); }
	@Test public void test_Ship_With_Length_RIGHT_3() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(3); }
	@Test public void test_Ship_With_Length_RIGHT_4() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(4); }
	@Test public void test_Ship_With_Length_RIGHT_5() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(5); }
	@Test public void test_Ship_With_Length_RIGHT_6() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(6); }
	@Test public void test_Ship_With_Length_RIGHT_7() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(7); }
	@Test public void test_Ship_With_Length_RIGHT_8() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(8); }
	@Test public void test_Ship_With_Length_RIGHT_9() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(9); }
	@Test public void test_Ship_With_Length_RIGHT_10() throws Exception { testSuccessDirectionRIGHT_X_Y_5_10(10); }

	@Test public void test_Ship_With_Length_TOP_1() throws Exception { testSuccessDirectionTOP_X_Y_1_5(1); }
	@Test public void test_Ship_With_Length_TOP_2() throws Exception { testSuccessDirectionTOP_X_Y_1_5(2); }
	@Test public void test_Ship_With_Length_TOP_3() throws Exception { testSuccessDirectionTOP_X_Y_1_5(3); }
	@Test public void test_Ship_With_Length_TOP_4() throws Exception { testSuccessDirectionTOP_X_Y_1_5(4); }
	@Test public void test_Ship_With_Length_TOP_5() throws Exception { testSuccessDirectionTOP_X_Y_1_5(5); }
	@Test public void test_Ship_With_Length_TOP_6() throws Exception { testSuccessDirectionTOP_X_Y_1_5(6); }
	@Test public void test_Ship_With_Length_TOP_7() throws Exception { testSuccessDirectionTOP_X_Y_1_5(7); }
	@Test public void test_Ship_With_Length_TOP_8() throws Exception { testSuccessDirectionTOP_X_Y_1_5(8); }
	@Test public void test_Ship_With_Length_TOP_9() throws Exception { testSuccessDirectionTOP_X_Y_1_5(9); }
	@Test public void test_Ship_With_Length_TOP_10() throws Exception { testSuccessDirectionTOP_X_Y_1_5(10); }

	@Test public void test_Ship_With_Length_BOTTOM_1() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(1); }
	@Test public void test_Ship_With_Length_BOTTOM_2() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(2); }
	@Test public void test_Ship_With_Length_BOTTOM_3() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(3); }
	@Test public void test_Ship_With_Length_BOTTOM_4() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(4); }
	@Test public void test_Ship_With_Length_BOTTOM_5() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(5); }
	@Test public void test_Ship_With_Length_BOTTOM_6() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(6); }
	@Test public void test_Ship_With_Length_BOTTOM_7() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(7); }
	@Test public void test_Ship_With_Length_BOTTOM_8() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(8); }
	@Test public void test_Ship_With_Length_BOTTOM_9() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(9); }
	@Test public void test_Ship_With_Length_BOTTOM_10() throws Exception { testSuccessDirectionBOTTOM_X_Y_10_5(10); }

	private void testSuccessDirectionLEFT_X_Y_5_1(int length) {
		Ship ship = new Ship(GameUtil.DIRECTION_LEFT,length, 5 , 1);
		Assert.assertTrue(ship.setupLocations(new HashSet<Location>()));
		Assert.assertTrue(ship.getLocations() != null);
		Assert.assertTrue(ship.getLocations().size() == length);
	}
	
	private void testSuccessDirectionRIGHT_X_Y_5_10(int length) {
		Ship ship = new Ship(GameUtil.DIRECTION_RIGHT,length, 5 , 10);
		Assert.assertTrue(ship.setupLocations(new HashSet<Location>()));
		Assert.assertTrue(ship.getLocations() != null);
		Assert.assertTrue(ship.getLocations().size() == length);
	}

	private void testSuccessDirectionTOP_X_Y_1_5(int length) {
		Ship ship = new Ship(GameUtil.DIRECTION_TOP,length, 1 , 5);
		Assert.assertTrue(ship.setupLocations(new HashSet<Location>()));
		Assert.assertTrue(ship.getLocations() != null);
		Assert.assertTrue(ship.getLocations().size() == length);
	}
	
	private void testSuccessDirectionBOTTOM_X_Y_10_5(int length) {
		Ship ship = new Ship(GameUtil.DIRECTION_BOTTOM,length, 10 , 5);
		Assert.assertTrue(ship.setupLocations(new HashSet<Location>()));
		Assert.assertTrue(ship.getLocations() != null);
		Assert.assertTrue(ship.getLocations().size() == length);
	}

	@Test
	public void test_Ship_Failure_X_Y_0_0() throws Exception {
		Ship ship = new Ship(GameUtil.DIRECTION_LEFT,2, 0 , 0);
		Assert.assertFalse(ship.setupLocations(new HashSet<Location>()));
	}

	@Test
	public void test_Ship_Failure_Length_0() throws Exception {
		Ship ship = new Ship(GameUtil.DIRECTION_LEFT,0, 1 , 1);
		Assert.assertFalse(ship.setupLocations(new HashSet<Location>()));
	}

	@Test
	public void test_Ship_With_Length_2_Failure() throws Exception {
		int length = 2;
		Ship ship = new Ship(GameUtil.DIRECTION_RIGHT,length, 1 , 1);
		Assert.assertFalse(ship.setupLocations(new HashSet<Location>()));
	}

	@Test
	public void test_Ship_With_Length_3_Failure() throws Exception {
		int length = 2;
		Ship ship = new Ship(GameUtil.DIRECTION_RIGHT,length, 1 , 1);
		Assert.assertFalse(ship.setupLocations(new HashSet<Location>()));
	}
}
