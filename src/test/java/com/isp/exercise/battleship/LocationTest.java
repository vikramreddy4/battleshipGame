package com.isp.exercise.battleship;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.isp.exercise.Location;

public class LocationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test_X_Y_0_0() throws Exception {
		Location location = new Location(0,0);
		Assert.assertFalse(location.isValid());
	}

	@Test
	public void test_X_Y_0_1() throws Exception {
		Location location = new Location(0,1);
		Assert.assertFalse(location.isValid());
	}

	@Test
	public void test_X_Y_1_0() throws Exception {
		Location location = new Location(1,0);
		Assert.assertFalse(location.isValid());
	}

	@Test
	public void test_X_Y_1_1() throws Exception {
		Location location = new Location(1,1);
		Assert.assertTrue(location.isValid());
	}

	@Test
	public void test_X_Y_10_11() throws Exception {
		Location location = new Location(10,11);
		Assert.assertFalse(location.isValid());
	}

	@Test
	public void test_X_Y_11_10() throws Exception {
		Location location = new Location(11,10);
		Assert.assertFalse(location.isValid());
	}
	
	@Test
	public void test_X_Y_10_10() throws Exception {
		Location location = new Location(10,10);
		Assert.assertTrue(location.isValid());
	}

	@Test
	public void test_X_Y_5_5() throws Exception {
		Location location = new Location(5,5);
		Assert.assertTrue(location.isValid());
	}
}
