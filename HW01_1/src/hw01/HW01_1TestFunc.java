package hw01;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1TestFunc 
{

	@Test
	public void testFunc1() 
	{
		int res = HW01_1.func(0, 0);
		assertEquals(0, res);		// assertEquals(expected, actual)
	}

	@Test
	public void testFunc2() 
	{
		int res = HW01_1.func(2, 2);
		assertEquals(4, res);		
	}
	
	@Test
	public void testFunc3() 
	{
		int res = HW01_1.func(1, 2);
		assertEquals(3, res);		
	}
	
}
