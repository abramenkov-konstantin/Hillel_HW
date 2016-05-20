package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestSummEven 
{
	@Test
	public void testSummEven1() 
	{
		int res = HW01_2.summEven();
		assertEquals(2450, res);		
	}
		

}
