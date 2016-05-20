package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestIndexMin 
{
	@Test (expected = IllegalArgumentException.class)
	public void testIndexMinNull() 
	{
		int [] ini = null;
		HW01_3.indexMin(ini);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testIndexMin0() 
	{
		int [] ini = {};
		HW01_3.indexMin(ini);
		}
	
	@Test
	public void testIndexMin1() 
	{
		int [] ini =  {10};
		int res = HW01_3.indexMin(ini);
		assertEquals(0, res);
	}
	@Test
	public void testIndexMin2() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.indexMin(ini);
		assertEquals(0, res);
	}
	
	@Test
	public void testIndexMinMany() 
	{
		int [] ini =  {10, 2, 56, 65, 7, 1, 64, 10};
		int res = HW01_3.indexMin(ini);
		assertEquals(5, res);
	}
	
}
