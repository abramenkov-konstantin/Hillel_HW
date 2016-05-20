package hw01_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_4TestGetWordValue 
{
	@Test (expected = IllegalArgumentException.class)
	public void testGetWordValue0() 
	{
		HW01_4.getNameOfDay(0);
	}
	
	@Test
	public void testGetWordValue123() 
	{
		String res = HW01_4.getWordValueAll("123");
		assertEquals("��� �������� ��� ", res);		
	}
	@Test
	public void testGetWordValue256() 
	{
		String res = HW01_4.getWordValueAll("256");
		assertEquals("������ ��������� ����� ", res);		
	}
	@Test
	public void testGetWordValue654() 
	{
		String res = HW01_4.getWordValueAll("654");
		assertEquals("�������� ��������� ������ ", res);		
	}
	
	@Test
	public void testGetWordValue1000() 
	{
		String res = HW01_4.getWordValueAll("1000");
		assertEquals("���� ������ ", res);		
	}
	@Test
	public void testGetWordValue2000() 
	{
		String res = HW01_4.getWordValueAll("2000");
		assertEquals("��� ������ ", res);		
	}
	@Test
	public void testGetWordValue1000000() 
	{
		String res = HW01_4.getWordValueAll("1000000");
		assertEquals("���� ������� ", res);		
	}
	@Test
	public void testGetWordValue2000000() 
	{
		String res = HW01_4.getWordValueAll("2000000");
		assertEquals("��� �������� ", res);		
	}
	@Test
	public void testGetWordValue1000000000() 
	{
		String res = HW01_4.getWordValueAll("1000000000");
		assertEquals("���� �������� ", res);		
	}
	@Test
	public void testGetWordValue2000000000() 
	{
		String res = HW01_4.getWordValueAll("2000000000");
		assertEquals("��� ��������� ", res);		
	}
	@Test
	public void testGetWordValue35256412565() 
	{
		String res = HW01_4.getWordValueAll("35256422565");
		assertEquals("�������� ���� ���������� ������ ��������� ����� ��������� ��������� �������� ��� ������ ������� ���������� ���� ", res);		
	}

	
}
