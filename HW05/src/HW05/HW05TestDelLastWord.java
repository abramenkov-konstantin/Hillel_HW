package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestDelLastWord 
{
	@Test (expected = IllegalArgumentException.class)
	public void testDelLastWordNull() 
	{
		HW05.delLastWord(null);
	}
	@Test
	public void testDelLastWord1() 
	{
		String res = HW05.delLastWord("����,��, ���");
		assertEquals("����,��,", res);
	}
	@Test
	public void testDelLastWord2() 
	{
		String res = HW05.delLastWord("123123 332432432 34324 ����,��, �� � 2312312");
		assertEquals("123123 332432432 34324 ����,��, �� �", res);
	}
	@Test
	public void testDelLastWord3() 
	{
		String res = HW05.delLastWord("123123 324234");
		assertEquals("123123", res);
	}
	
}
