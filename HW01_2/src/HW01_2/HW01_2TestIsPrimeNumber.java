package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestIsPrimeNumber 
{
	@Test (expected = IllegalArgumentException.class)
	public void testIsPrimeNumber00() 
	{
	HW01_2.isPrimeNumber(-1);
				
	}
	
	@Test
	public void testIsPrimeNumber0() 
	{
		boolean res = HW01_2.isPrimeNumber(0);
		assertEquals(true, res);		
	}
	@Test
	public void testIsPrimeNumber1() 
	{
		boolean res = HW01_2.isPrimeNumber(1);
		assertEquals(true, res);		
	}
	@Test
	public void testIsPrimeNumber2() 
	{
		boolean res = HW01_2.isPrimeNumber(2);
		assertEquals(true, res);		
	}
	@Test
	public void testIsPrimeNumber3() 
	{
		boolean res = HW01_2.isPrimeNumber(3);
		assertEquals(true, res);		
	}
	@Test
	public void testIsPrimeNumber4() 
	{
		boolean res = HW01_2.isPrimeNumber(4);
		assertEquals(false, res);		
	}
	@Test
	public void testIsPrimeNumber5() 
	{
		boolean res = HW01_2.isPrimeNumber(5);
		assertEquals(true, res);		
	}


}
