package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1_3Test 
{

	@Test
	public void testSumm3() 
	{
		int res = HW01_1_3.summ3(0, 0,0);
		assertEquals(0, res);
	}
	@Test
	public void testSumm31() 
	{
		int res = HW01_1_3.summ3(1,-1, -1);
		assertEquals(1, res);
	}
	@Test
	public void testSumm32() 
	{
		int res = HW01_1_3.summ3(-1,-1, -1);
		assertEquals(0, res);
	}
	@Test
	public void testSumm33() 
	{
		int res = HW01_1_3.summ3(1, 1, -1);
		assertEquals(2, res);
	}
	@Test
	public void testSumm34() 
	{
		int res = HW01_1_3.summ3(1,1, 1);
		assertEquals(3, res);
	}

}
