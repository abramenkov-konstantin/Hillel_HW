package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2_1TestSumm 
{
	@Test
	public void testSummEven1() 
	{
		int res = HW01_2_1.summEven(1, 2);
		assertEquals(2, res);		
	}
	@Test
	public void testSummEven2() 
	{
		int res = HW01_2_1.summEven(1, 10);
		assertEquals(30, res);		
	}
	@Test
	public void testSummEven3() 
	{
		int res = HW01_2_1.summEven(1, 100);
		assertEquals(2550, res);		
	}
	

}
