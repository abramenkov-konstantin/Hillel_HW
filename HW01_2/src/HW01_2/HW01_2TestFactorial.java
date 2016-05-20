package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestFactorial 
{
	@Test
	public void testFactorial0() 
	{
		double res = HW01_2.factorial(0);
		assertEquals(res, 0, res);		
	}
	@Test
	public void testFactorial1() 
	{
		double res = HW01_2.factorial(1);
		assertEquals(res, 1, res);		
	}
	@Test
	public void testFactorial2() 
	{
		double res = HW01_2.factorial(2);
		assertEquals(res, 2, res);		
	}
	@Test
	public void testFactorial3() 
	{
		double res = HW01_2.factorial(3);
		assertEquals(res, 6, res);		
	}
	@Test
	public void testFactorial4() 
	{
		double res = HW01_2.factorial(4);
		assertEquals(res, 24, res);		
	}
}
