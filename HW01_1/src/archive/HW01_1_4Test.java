package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1_4Test 
{

	@Test
	public void testMax() 
	{
		int res = HW01_1_4.max(0, 0, 0);
		assertEquals(3, res);
	}
	
	@Test
	public void testMax1() 
	{
		int res = HW01_1_4.max(1, 1, 1);
		assertEquals(6, res);
	}
	
	@Test
	public void testMax2() 
	{
		int res = HW01_1_4.max(2, 2, 2);
		assertEquals(11, res);
	}
	
	@Test
	public void testMax3() 
	{
		int res = HW01_1_4.max(3, 3, 3);
		assertEquals(30, res);
	}
	

}
