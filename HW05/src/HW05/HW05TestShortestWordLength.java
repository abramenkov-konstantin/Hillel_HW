package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestShortestWordLength 
{

	@Test (expected = IllegalArgumentException.class)
	public void testShortestWordLengthNull() 
	{
		HW05.shortestWordLength (null);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testShortestWordLengthNull2() 
	{
		HW05.shortestWordLength ("");
	}
	@Test
	public void testShortestWordLength1() 
	{
		int res= HW05.shortestWordLength ("Как же прекрасен кэтот чудесный,замечательный и?изумительный мир!  ");
		assertEquals(res, 1);	
	}
	@Test
	public void testShortestWordLength2() 
	{
		int res= HW05.shortestWordLength ("Как же прекрасен");
		assertEquals(res, 2);	
	}
	@Test
	public void testShortestWordLength3() 
	{
		int res= HW05.shortestWordLength ("Как рекрасен кэтот");
		assertEquals(res, 3);	
	}
	@Test
	public void testShortestWordLengthMany() 
	{
		int res= HW05.shortestWordLength ("Каfgк wefwefw asdaqsdd 12124312312432 екрасен кэтот");
		assertEquals(res, 5);	
	}

}
