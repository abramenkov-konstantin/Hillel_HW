package hw04;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW04TestFunc 
{
	@Test (expected = ArithmeticException.class)
	public void testFuncEx() 
	{
		HW04.func(1.);
	}
	@Test 
	public void testFunc01() 
	{
		double res= HW04.func(0.);
		assertEquals(res, 1.0, res);
	}
	}
