package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestMin 
{
	@Test (expected = IllegalArgumentException.class)
	public void testMinNull() 
	{
		int [] ini = null;
		HW01_3.min(ini);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testMin0() 
	{
		int [] ini = {};
		HW01_3.min(ini);
		}
	
	@Test
	public void testMin1() 
	{
		int [] ini =  {10};
		int res = HW01_3.min(ini);
		assertEquals(10, res);
	}
	@Test
	public void testMin2() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.min(ini);
		assertEquals(10, res);
	}
	
	@Test
	public void testMinMany() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10};
		int res = HW01_3.min(ini);
		assertEquals(10, res);
	}
	
	@Test
	public void testMinMany2() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10, 6, 78, 98};
		int res = HW01_3.min(ini);
		assertEquals(6, res);
	}
	

}
