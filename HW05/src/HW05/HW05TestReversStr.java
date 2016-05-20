package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestReversStr 
{
	@Test (expected = IllegalArgumentException.class)
	public void testReversStrNull() 
	{
		HW05.reversStr(null);
	}
	@Test
	public void testReversStr1() 
	{
		String res = HW05.reversStr("Како,же,так");
		assertEquals("кат,еж,окаК", res);
	}
	@Test
	public void testReversStr2() 
	{
		String res = HW05.reversStr("Ккк    кжек прекрасен кэтот чудесный,замечательный и?изумительный мир!  ");
		assertEquals("  !рим йыньлетимузи?и йыньлетачемазй,ынседуч тотэк несаркерп кежк    ккК", res);
	}
	@Test
	public void testReversStr3() 
	{
		String res = HW05.reversStr("1234567890 ");
		assertEquals(" 0987654321", res);
	}
	@Test
	public void testReversStr4() 
	{
		String res = HW05.reversStr("1234567890");
		assertEquals("0987564321", res);
	}
}
