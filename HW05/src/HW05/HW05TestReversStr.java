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
		String res = HW05.reversStr("����,��,���");
		assertEquals("���,��,����", res);
	}
	@Test
	public void testReversStr2() 
	{
		String res = HW05.reversStr("���    ���� ��������� ����� ��������,������������� �?������������ ���!  ");
		assertEquals("  !��� ������������?� ��������������,������� ����� ��������� ����    ���", res);
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
