package hw01;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_1TestRate 
{
	@Test (expected = IllegalArgumentException.class)
	public void testRate0() 
	{
		HW01_1.rate(-1);

	}
	@Test (expected = IllegalArgumentException.class)
	public void testRate101() 
	{
		HW01_1.rate(101);
	}
	@Test
	public void testRate00() 
	{
		char res = HW01_1.rate(0);
		assertEquals('F', res);
	}

	@Test
	public void testRate19() 
	{
		char res = HW01_1.rate(19);
		assertEquals('F', res);
	}
	@Test
	public void testRate20() 
	{
		char res = HW01_1.rate(20);
		assertEquals('E', res);
	}
	@Test
	public void testRate39() 
	{
		char res = HW01_1.rate(39);
		assertEquals('E', res);
	}
	@Test
	public void testRate40() 
	{
		char res = HW01_1.rate(40);
		assertEquals('D', res);
	}
	@Test
	public void testRate59() 
	{
		char res = HW01_1.rate(59);
		assertEquals('D', res);
	}
	@Test
	public void testRate60() 
	{
		char res = HW01_1.rate(60);
		assertEquals('C', res);
	}
	@Test
	public void testRate74() 
	{
		char res = HW01_1.rate(74);
		assertEquals('C', res);
	}
	@Test
	public void testRate75() 
	{
		char res = HW01_1.rate(75);
		assertEquals('B', res);
	}
	@Test
	public void testRate89() 
	{
		char res = HW01_1.rate(89);
		assertEquals('B', res);
	}
	@Test
	public void testRate90() 
	{
		char res = HW01_1.rate(90);
		assertEquals('A', res);
	}
	@Test
	public void testRate100() 
	{
		char res = HW01_1.rate(100);
		assertEquals('A', res);
	}

}
