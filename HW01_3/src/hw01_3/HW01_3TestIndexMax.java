package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestIndexMax 
{
	@Test (expected = IllegalArgumentException.class)
	public void testIndexMaxNull() 
	{
		int [] ini = null;
		HW01_3.indexMax(ini);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testIndexMax0() 
	{
		int [] ini = {};
		HW01_3.indexMax(ini);
		}
	
	@Test
	public void testIndexMax1() 
	{
		int [] ini =  {10};
		int res = HW01_3.indexMax(ini);
		assertEquals(0, res);
	}
	@Test
	public void testIndexMax2() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.indexMax(ini);
		assertEquals(1, res);
	}
	
	@Test
	public void testIndexMaxMany() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10};
		int res = HW01_3.indexMax(ini);
		assertEquals(5, res);
	}
	

}
