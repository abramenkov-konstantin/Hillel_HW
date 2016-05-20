package HW05;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW05TestCountWords 
{
	@Test (expected = IllegalArgumentException.class)
	public void testCountWordsNull0() 
	{
		HW05.countWords(null);
	}
	
	@Test
	public void testCountWords1() 
	{
		String in = "1234567890 3234234 54344";
		int out = HW05.countWords(in);
		assertEquals(3, out);
	}
		@Test
	public void testCountWords2() 
	{
		String in = "1234567890 3234234 54344 34534fsd sdfswfsd";
		int out = HW05.countWords(in);
		assertEquals(5, out);
	}
		@Test
		public void testCountWords3() 
		{
			String in = "1234567890 3234234 54344 34534fsd sdfswfsd   ";
			int out = HW05.countWords(in);
			assertEquals(5, out);
		}
		@Test
		public void testCountWords4() 
		{
			String in = "   1234567890   3234234 54344? 34534fsd sdfswfsd    ";
			int out = HW05.countWords(in);
			assertEquals(5, out);
		}
		
	

}
