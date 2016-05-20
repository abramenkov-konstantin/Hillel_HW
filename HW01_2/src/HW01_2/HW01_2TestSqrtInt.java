package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestSqrtInt 
{
	@Test (expected = IllegalArgumentException.class)
	public void testSqrtInt00() 
	{
		HW01_2.sqrtInt(-1);
	}
	@Test
	public void testSqrtInt0() 
	{
		int res = HW01_2.sqrtInt(0);
		assertEquals(0, res);		
	}
	@Test
	public void testSqrtInt1() 
	{
		int res = HW01_2.sqrtInt(1);
		assertEquals(1, res);		
	}
	@Test
	public void testSqrtInt2() 
	{
		int res = HW01_2.sqrtInt(2);
		assertEquals(1, res);		
	}
	@Test
	public void testSqrtInt4() 
	{
		int res = HW01_2.sqrtInt(4);
		assertEquals(2, res);		
	}
	@Test
	public void testSqrtInt25() 
	{
		int res = HW01_2.sqrtInt(25);
		assertEquals(5, res);		
	}
	@Test
	public void testSqrtInt26() 
	{
		int res = HW01_2.sqrtInt(26);
		assertEquals(5, res);		
	}


}
