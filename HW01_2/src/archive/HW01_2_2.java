package archive;

public class HW01_2_2 
{
	// 02 �����
	// 02 ���������, ������� �� �����
	
	public static void main(String[] args) 
	{
		int a=2;
		boolean isPrime;
	
		
		isPrime = isPrimeNumber (a);
		
		if (isPrime)
		{
			System.out.println("����� " + a + " �������");
		}
		else
		{
			System.out.println("����� " + a + " �����������");
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
			System.out.println("������� �����: " + i);
			count2++;
		}
	}
	System.out.println("����� ������� ����� ���������: " + count2);*/
}
