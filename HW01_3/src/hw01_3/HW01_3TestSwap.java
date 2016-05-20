package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestSwap 
{

	@Test (expected = IllegalArgumentException.class)
	public void testIndexSwap1() 
	{
		int [] arr = null;
		HW01_3.swap(arr);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testIndexSwap2() 
	{
		int [] arr = {};
		HW01_3.swap(arr);
	}
	@Test
	public void testIndexSwap3() 
	{
		int [] arr = {15, 21, 58, 25, 5};
		int [] arr_expected = {25, 5, 58, 15, 21};
		
		assertArrayEquals(arr_expected, HW01_3.swap(arr));
		
	}
	@Test
	public void testIndexSwap4() 
	{
		int [] arr = {18, 45, 11, 67, 67, 79};
		int [] arr_expected = {67, 67, 79, 18, 45, 11};
		
		assertArrayEquals(arr_expected, HW01_3.swap(arr));
	}
}
