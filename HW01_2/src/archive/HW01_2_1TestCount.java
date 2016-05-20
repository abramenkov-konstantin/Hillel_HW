package archive;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2_1TestCount 
{

	@Test
	public void testCountEven() 
	{
		int res = HW01_2_1.countEven(1, 2);
		assertEquals(1, res);		
	}
	@Test
	public void testCountEven1() 
	{
		int res = HW01_2_1.countEven(1, 10);
		assertEquals(5, res);		
	}
	@Test
	public void testCountEven2() 
	{
		int res = HW01_2_1.countEven(1, 100);
		assertEquals(50, res);		
	}
	
	

}
