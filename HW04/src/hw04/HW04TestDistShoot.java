package hw04;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW04TestDistShoot 
{
	@Test (expected = IllegalArgumentException.class)
	public void testDistShootEx() 
	{
		HW04.distShoot(0., 0.);
	}

	@Test
	public void testDistShoot1() 
	{
		double res= HW04.distShoot(700., 45.);
		assertEquals(res, 50000.0, res);	
	}

}
