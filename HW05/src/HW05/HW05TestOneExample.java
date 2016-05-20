package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestOneExample
{
	@Test (expected = IllegalArgumentException.class)
	public void testtestOneExampleNull() 
	{
		HW05.oneExample(null);
	}
	@Test
	public void testOneExample1() 
	{
		String res = HW05.oneExample("Како,же,так");
		assertEquals("Како,жет", res);
	}
	@Test
	public void testOneExample2() 
	{
		String res = HW05.oneExample("Ккк кжек прекрасен кэтот чудесный,замечательный и?изумительный мир!  ");
		assertEquals("Кк жепраснэточудый,змльи?!", res);
	}
	
	@Test
	public void testOneExample3() 
	{
		String res = HW05.oneExample("Agr aaadddfff");
		assertEquals("Agr adf", res);
	}

}
