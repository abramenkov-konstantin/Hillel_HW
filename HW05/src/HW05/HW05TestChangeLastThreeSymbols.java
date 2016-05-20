package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestChangeLastThreeSymbols 
{

	@Test (expected = IllegalArgumentException.class)
	public void testChangeLastThreeSymbolsNull() 
	{
		HW05.changeLastThreeSymbols(null,3);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testChangeLastThreeSymbolsNull2() 
	{
		String in[] = {"����", "��", "���"};
		HW05.changeLastThreeSymbols(in,2);
	}
	@Test
	public void testChangeLastThreeSymbols04() 
	{
		String in[] = {"����", "��", "���"};
		String out[] = {"�$", "��", "���"};		
		String res [] = HW05.changeLastThreeSymbols(in,4);
		assertArrayEquals(out, res);
	}
	@Test
	public void testChangeLastThreeSymbols03() 
	{
		String in[] = {"����", "��", "���"};
		String out[] = {"����", "��", "$"};		
		String res [] = HW05.changeLastThreeSymbols(in,3);
		assertArrayEquals(out, res);
	}
	

}
