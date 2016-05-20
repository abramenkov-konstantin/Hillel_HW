package hw01;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1TestQarter 
{
	@Test (expected = IllegalArgumentException.class)
	public void testQuarter00() 
	{
		HW01_1.quarter(0, 0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void testQuarter01() 
	{
		HW01_1.quarter(1, 0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testQuarter02() 
	{
		HW01_1.quarter(0, 1);
	}
	@Test
	public void testQuarter1() 
	{
		int res = HW01_1.quarter(1, 1);
		assertEquals(1, res);
	}
	@Test
	public void testQuarter2() 
	{
		int res = HW01_1.quarter(-1, 1);
		assertEquals(2, res);
	}
	@Test
	public void testQuarter3() 
	{
		int res = HW01_1.quarter(-1, -1);
		assertEquals(3, res);
	}
	@Test
	public void testQuarter4() 
	{
		int res = HW01_1.quarter(1, -1);
		assertEquals(4, res);
	}
}
