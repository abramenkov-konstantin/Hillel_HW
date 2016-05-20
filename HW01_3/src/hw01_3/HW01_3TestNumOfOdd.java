package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestNumOfOdd 
{
	@Test (expected = IllegalArgumentException.class)
	public void testNumOfOddNull() 
	{
		int [] ini = null;
		HW01_3.numOfOdd(ini);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testNumOfOdd0() 
	{
		int [] ini = {};
		HW01_3.numOfOdd(ini);
	}

	@Test
	public void testNumOfOdd1_1() 
	{
		int [] ini =  {10};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(0, res);
	}
	@Test
	public void testNumOfOdd1_2() 
	{
		int [] ini =  {13};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(1, res);
	}
	@Test
	public void testNumOfOdd2_1() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(0, res);
	}
	@Test
	public void testNumOfOdd2_2() 
	{
		int [] ini =  {11, 24};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(1, res);
	}
	@Test
	public void testNumOfOdd2_3() 
	{
		int [] ini =  {11, 13};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(2, res);
	}
	@Test
	public void testNumOfOddMany() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(3, res);
	}

	@Test
	public void testNumOfOddMany2() 
	{
		int [] ini =  {15, 24, 56, 65, 13, 67, 64, 10, 6, 78, 99};
		int res = HW01_3.numOfOdd(ini);
		assertEquals(5, res);
	}
}
