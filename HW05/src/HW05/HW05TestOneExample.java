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
		String res = HW05.oneExample("����,��,���");
		assertEquals("����,���", res);
	}
	@Test
	public void testOneExample2() 
	{
		String res = HW05.oneExample("��� ���� ��������� ����� ��������,������������� �?������������ ���!  ");
		assertEquals("�� ���������������,�����?!", res);
	}
	
	@Test
	public void testOneExample3() 
	{
		String res = HW05.oneExample("Agr aaadddfff");
		assertEquals("Agr adf", res);
	}

}
