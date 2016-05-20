package hw01_3;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_3TestSortInsert {

	@Test (expected = IllegalArgumentException.class)
	public void testIndexSortInsert1() 
	{
		int [] arr = null;
		HW01_3.sortInsert(arr);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testIndexSortInsert2() 
	{
		int [] arr = {};
		HW01_3.sortInsert(arr);
	}
	@Test
	public void testIndexSortInsert3() 
	{
		int [] arr = {15, 21, 58, 25, 5};
		int [] arr_expected = {5, 15, 21, 25, 58};
		
		assertArrayEquals(arr_expected, HW01_3.sortInsert(arr));
		
	}
	@Test
	public void testIndexSortInsert4() 
	{
		int [] arr = {18, 45, 11, 76, 67, 67, 79};
		int [] arr_expected = {11, 18, 45, 67, 67, 76, 79};
		
		assertArrayEquals(arr_expected, HW01_3.sortInsert(arr));
	}

}
