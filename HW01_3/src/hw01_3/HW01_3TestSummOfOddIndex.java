package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestSummOfOddIndex
{

	@Test (expected = IllegalArgumentException.class)
	public void testSumOfOddIndexNull() 
	{
		int [] ini = null;
		HW01_3.sumOfOddIndex(ini);
	}
		
	@Test (expected = IllegalArgumentException.class)
	public void testSumOfOddIndex0() 
	{
		int [] ini = {};
		HW01_3.sumOfOddIndex(ini);
		}
	
	@Test
	public void testSumOfOddIndex1_1() 
	{
		int [] ini =  {10};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(10, res);
	}
	@Test
	public void testSumOfOddIndex1_2() 
	{
		int [] ini =  {13};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(0, res);
	}
	@Test
	public void testSumOfOddIndex2_1() 
	{
		int [] ini =  {10, 24};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(10, res);
	}
	@Test
	public void testSumOfOddIndex2_2() 
	{
		int [] ini =  {11, 24};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(24, res);
	}
	@Test
	public void testSumOfOddIndex2_3() 
	{
		int [] ini =  {11, 13};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(0, res);
	}
	@Test
	public void testSumOfOddIndexMany() 
	{
		int [] ini =  {10, 24, 56, 65, 13, 67, 64, 10};
		int res = HW01_3.sumOfOddIndex(ini);
		assertEquals(166, res);
	}
	
	

}
