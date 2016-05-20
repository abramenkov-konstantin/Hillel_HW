package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestRevers {

	@Test (expected = IllegalArgumentException.class)
	public void testIndexReversArray1() 
	{
		int [] arr = null;
		HW01_3.revers(arr);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testIndexReversArray2() 
	{
		int [] arr = {};
		HW01_3.revers(arr);
	}
	@Test
	public void testIndexReversArray3() 
	{
		int [] arr = {15, 21, 58, 25, 5};
		int [] arr_expected = {5, 25, 58, 21, 15};
		
		assertArrayEquals(arr_expected, HW01_3.revers(arr));
		
	}
	@Test
	public void testIndexReversArray4() 
	{
		int [] arr = {18, 45, 11, 76, 67, 67, 79};
		int [] arr_expected = {79, 67, 67, 76, 11, 45, 18};
		
		assertArrayEquals(arr_expected, HW01_3.revers(arr));
	}
}
