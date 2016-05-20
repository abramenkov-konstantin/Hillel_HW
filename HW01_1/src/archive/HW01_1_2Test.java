package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1_2Test 
{

	@Test
	public void testQuarter() 
	{
		int res = HW01_1_2.quarter(0, 0);
		assertEquals(0, res);
	}
	@Test
	public void testQuarter1() 
	{
		int res = HW01_1_2.quarter(1, 1);
		assertEquals(1, res);
	}
	@Test
	public void testQuarter2() 
	{
		int res = HW01_1_2.quarter(-1, 1);
		assertEquals(2, res);
	}
	@Test
	public void testQuarter3() 
	{
		int res = HW01_1_2.quarter(-1, -1);
		assertEquals(3, res);
	}
	@Test
	public void testQuarter4() 
	{
		int res = HW01_1_2.quarter(1, -1);
		assertEquals(4, res);
	}

}
