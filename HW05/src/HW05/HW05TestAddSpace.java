package HW05;

import static org.junit.Assert.*;

import org.junit.Test;


public class HW05TestAddSpace {

	@Test (expected = IllegalArgumentException.class)
	public void testChangeLastThreeSymbolsNull() 
	{
		HW05.addSpace(null);
	}
	@Test
	public void testAddSpace1() 
	{
		String res = HW05.addSpace("����,��,���");
		assertEquals("����, ��, ���", res);
	}
	@Test
	public void testAddSpace2() 
	{
		String res = HW05.addSpace("��� �� ���������    ���� ��������,������������� �?������������ ���!  ");
		assertEquals("��� �� ��������� ���� ��������, ������������� �? ������������ ���!", res);
	}
	@Test
	public void testAddSpace3() 
	{
		String res = HW05.addSpace("    ���-��,�    ...    ");
		assertEquals("���-��, � ...", res);
	}
	
}
