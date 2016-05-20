package hw04;

import static org.junit.Assert.*;

import org.junit.Test;
public class HW04TestDistAuto 
{
	@Test (expected = IllegalArgumentException.class)
	public void testDistAutoEx01() 
	{
		HW04.distAuto(0., 0., 0., 0.);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDistAutoEx02() 
	{
		HW04.distAuto(0., 1., 1., 1.);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDistAutoEx03() 
	{
		HW04.distAuto(1., 0., 1., 1.);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDistAutoEx04() 
	{
		HW04.distAuto(1., 1., 0., 1.);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDistAutoEx05() 
	{
		HW04.distAuto(1., 1., 1., 0.);
	}
	
	@Test
	public void testDistAuto1() 
	{
		double res= HW04.distAuto(10., 10., 1., 20);
		assertEquals(res, 40.0, res);	
	}
}

