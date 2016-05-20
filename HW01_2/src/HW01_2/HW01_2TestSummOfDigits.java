package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestSummOfDigits 
{
	@Test
	public void testSummOfDigits0() 
	{
		int res = HW01_2.summOfDigits(0);
		assertEquals(0, res);		
	}
	@Test
	public void testSummOfDigits1() 
	{
		int res = HW01_2.summOfDigits(1);
		assertEquals(1, res);		
	}
	@Test
	public void testSummOfDigits123() 
	{
		int res = HW01_2.summOfDigits(123);
		assertEquals(6, res);		
	}
	@Test
	public void testSummOfDigits1234() 
	{
		int res = HW01_2.summOfDigits(1234);
		assertEquals(10, res);		
	}
	
	@Test
	public void testSummOfDigits4() 
	{
		int res = HW01_2.summOfDigits(-2);
		assertEquals(2, res);		
	}


	
}
