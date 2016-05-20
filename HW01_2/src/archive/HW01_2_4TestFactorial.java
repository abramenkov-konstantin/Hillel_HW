package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2_4TestFactorial 
{

	@Test
	public void testFactorial0() 
	{
		int res = HW01_2_4.factorial(0);
		assertEquals(0, res);		
	}
	@Test
	public void testFactorial1() 
	{
		int res = HW01_2_4.factorial(1);
		assertEquals(1, res);		
	}
	@Test
	public void testFactorial2() 
	{
		int res = HW01_2_4.factorial(2);
		assertEquals(2, res);		
	}
	@Test
	public void testFactorial3() 
	{
		int res = HW01_2_4.factorial(3);
		assertEquals(6, res);		
	}
	@Test
	public void testFactorial4() 
	{
		int res = HW01_2_4.factorial(4);
		assertEquals(24, res);		
	}
	
	

}
