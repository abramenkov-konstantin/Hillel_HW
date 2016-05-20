package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2_5TestSummOfDigits 
{

	@Test
	public void testSummOfDigits0() 
	{
		int res = HW01_2_5.summOfDigits(0);
		assertEquals(0, res);		
	}
	@Test
	public void testSummOfDigits1() 
	{
		int res = HW01_2_5.summOfDigits(1);
		assertEquals(1, res);		
	}
	@Test
	public void testSummOfDigits2() 
	{
		int res = HW01_2_5.summOfDigits(123);
		assertEquals(6, res);		
	}
	@Test
	public void testSummOfDigits3() 
	{
		int res = HW01_2_5.summOfDigits(1234);
		assertEquals(10, res);		
	}
	
}
	
