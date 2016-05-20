package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestMax 
{

	@Test (expected = IllegalArgumentException.class)
	public void testMaxNull() 
	{
		int [] ini = null;
		HW01_3.max(ini);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testMax0() 
	{
		int [] ini = {};
		HW01_3.max(ini);
		}
	
	@Test
	public void testMax1() 
	{
		int [] ini =  {10};
		int res = HW01_3.max(ini);
		assertEquals(10, res);
	}
	@Test
	public void testMax2() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.max(ini);
		assertEquals(24, res);
	}
	
	@Test
	public void testMaxMany() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10};
		int res = HW01_3.max(ini);
		assertEquals(67, res);
	}
	

}
