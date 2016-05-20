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
		int res= HW05.shortestWordLength ("��� �� ��������� ����� ��������,������������� �?������������ ���!  ");
		assertEquals(res, 1);	
	}
	@Test
	public void testShortestWordLength2() 
	{
		int res= HW05.shortestWordLength ("��� �� ���������");
		assertEquals(res, 2);	
	}
	@Test
	public void testShortestWordLength3() 
	{
		int res= HW05.shortestWordLength ("��� �������� �����");
		assertEquals(res, 3);	
	}
	@Test
	public void testShortestWordLengthMany() 
	{
		int res= HW05.shortestWordLength ("��fg� wefwefw asdaqsdd 12124312312432 ������� �����");
		assertEquals(res, 5);	
	}

}
