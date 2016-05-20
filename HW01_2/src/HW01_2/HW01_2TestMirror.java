package HW01_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_2TestMirror 
{
	@Test (expected = IllegalArgumentException.class)
	public void testSqrtInt00() 
	{
		HW01_2.mirror(-1);
	}
	
	@Test
	public void testMirror1() 
	{
		int res = HW01_2.mirror(1);
		assertEquals(1, res);
	}
	@Test
	public void testMirror2() 
	{
		int res = HW01_2.mirror(12);
		assertEquals(21, res);
	}
	@Test
	public void testMirror3() 
	{
		int res = HW01_2.mirror(123);
		assertEquals(321, res);
	}
	@Test
	public void testMirror4() 
	{
		int res = HW01_2.mirror(1234);
		assertEquals(4321, res);
	}

}
