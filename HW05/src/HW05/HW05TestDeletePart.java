package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestDeletePart 
{
	@Test (expected = IllegalArgumentException.class)
	public void testDeletePartNull0() 
	{
		HW05.deletePart(null,3,4);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDeletePartNull1() 
	{
		String in = "1234567890";
		HW05.deletePart(in,-1,4);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testDeletePartNull2() 
	{
		String in = "1234567890";
		HW05.deletePart(in,1,20);
	}
	@Test
	public void testDeletePart1() 
	{
		String in = "1234567890";
		String out = HW05.deletePart(in,1,1);
		assertEquals("234567890", out);
	}
	@Test
	public void testDeletePart2() 
	{
		String in = "1234567890";
		String out = HW05.deletePart(in,2,1);
		assertEquals("134567890", out);
	}
	@Test
	public void testDeletePart3() 
	{
		String in = "1234567890";
		String out = HW05.deletePart(in,1,2);
		assertEquals("34567890", out);
	}

}
