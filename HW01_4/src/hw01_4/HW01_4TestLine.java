package hw01_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_4TestLine 
{
	@Test (expected = IllegalArgumentException.class)
	public void testLine0() 
	{
		HW01_4.line(0,0,0,0);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testLine1() 
	{
		HW01_4.line(1,1,1,1);
	}
	@Test
	public void testLine2() 
	{
		double res;
		res = HW01_4.line(0,3,0,4);
		assertEquals(res, 5., res);
	}
	@Test
	public void testLine3() 
	{
		double res;
		res = HW01_4.line(0,4,0,3);
		assertEquals(res, 5., res);
	}
}
