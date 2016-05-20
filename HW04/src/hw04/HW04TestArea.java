package hw04;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW04TestArea 
{
	@Test
	public void testAreaf0() 
	{
		assertEquals(false, HW04.area(-3., -3.));
	}
	@Test
	public void testAreaf2() 
	{
		assertEquals(false, HW04.area(-1., -1.));
	}
	@Test
	public void testAreaf3() 
	{
		assertEquals(false, HW04.area(3., 3.));
	}
	@Test
	public void testAreaf4() 
	{
		assertEquals(false, HW04.area(1., -1.));
	}
		@Test
	public void testAreat1() 
	{
		assertEquals(true, HW04.area(-2., 2.));
	}
	@Test
	public void testAreat2() 
	{
		assertEquals(true, HW04.area(-1., 0.5));
	}
	@Test
	public void testAreat3() 
	{
		assertEquals(true, HW04.area(-1., 1.));
	}
	@Test
	public void testAreat4() 
	{
		assertEquals(true, HW04.area(-0.5, -0.));
	}
	@Test
	public void testAreat5() 
	{
		assertEquals(true, HW04.area(-0., -1.));
	}
	@Test
	public void testAreat6() 
	{
		assertEquals(true, HW04.area(0., 0.));
	}
	@Test
	public void testAreat7() 
	{
		assertEquals(true, HW04.area(0.5, 0.));
	}
	@Test
	public void testAreat8() 
	{
		assertEquals(true, HW04.area(0.5, 0.5));
	}
	@Test
	public void testAreat9() 
	{
		assertEquals(true, HW04.area(1., 0.5));
	}
	@Test
	public void testAreat10() 
	{
		assertEquals(true, HW04.area(1., 1.));
	}
	

}
