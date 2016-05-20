package hw01_4;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW01_4TestGetNameOfDay 
{

	@Test (expected = IllegalArgumentException.class)
	public void testGetNameOfDay0() 
	{
		HW01_4.getNameOfDay(0);
	}
	@Test (expected = IllegalArgumentException.class)

	public void testGetNameOfDay8() 
	{
		HW01_4.getNameOfDay(8);
	}
	@Test
	public void testGetNameOfDay1() 
	{
		String res = HW01_4.getNameOfDay(1);
		assertEquals("Понедельник", res);		
	}
	@Test
	public void testGetNameOfDay2() 
	{
		String res = HW01_4.getNameOfDay(2);
		assertEquals("Вторник", res);		
	}
	@Test
	public void testGetNameOfDay3() 
	{
		String res = HW01_4.getNameOfDay(3);
		assertEquals("Среда", res);		
	}
	@Test
	public void testGetNameOfDay4() 
	{
		String res = HW01_4.getNameOfDay(4);
		assertEquals("Четверг", res);		
	}
	@Test
	public void testGetNameOfDay5() 
	{
		String res = HW01_4.getNameOfDay(5);
		assertEquals("Пятница", res);		
	}
	@Test
	public void testGetNameOfDay6() 
	{
		String res = HW01_4.getNameOfDay(6);
		assertEquals("Суббота", res);		
	}
	@Test
	public void testGetNameOfDay7() 
	{
		String res = HW01_4.getNameOfDay(7);
		assertEquals("Воскресенье", res);		
	}
}
