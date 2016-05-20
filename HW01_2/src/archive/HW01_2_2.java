package archive;

public class HW01_2_2 
{
	// 02 циклы
	// 02 проверить, простое ли число
	
	public static void main(String[] args) 
	{
		int a=2;
		boolean isPrime;
	
		
		isPrime = isPrimeNumber (a);
		
		if (isPrime)
		{
			System.out.println("Число " + a + " простое");
		}
		else
		{
			System.out.println("Число " + a + " комплексное");
		}
	}
	
	public static boolean isPrimeNumber (int x)
	{
		int count=0;
			for (int y=2; y<x; y++)
			{
				if (x%y==0)
				{
					count++;
				}
			}
		
		if (count==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/*for (i=1; i<100; i++)
	{
		count=0;
		for (y=2; y<i; y++)
		{
			if (i%y==0)
			{
				count++;
			}
		}
		if (count==0)
		{
			System.out.println("Простое число: " + i);
			count2++;
		}
	}
	System.out.println("Всего простых чисел насчитано: " + count2);*/
}
