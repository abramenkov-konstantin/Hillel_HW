package HW01_2;

public class HW01_2 
{
	// 02 �����
	// 01 ����� ����� ������ ����� � �� ���������� � ��������� 1-99
	// 02 ���������, ������� �� �����
	// 03 ����� ������ ������������ ����� � ��������� �� ������
	// ����������� ������� ����������������� ������� � ����� ��������� ������
	// 04 ��������� ��������� ����� n
	// 05 ��������� ����� ���� ��������� �����
	// 06 ������� �����, ������� �������� ���������� ������������ 
	// ������������������ ���� ��������� �����

	public static void main(String[] args) 
	{
		// 01 ����� ����� ������ ����� � �� ���������� � ��������� 1-99
		int summ=0, count=0;
		summ = summEven ();
		count = countEven ();
		System.out.println ("����� ������ ����� � ��������� [1,99] ����� "+ summ);
		System.out.println ("���������� ������ ����� � ��������� [1,99] ����� " + count);

		// 02 ���������, ������� �� �����
		int a=4;
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

		// 03 ����� ������ ������������ ����� � ��������� �� ������
		// ����������� ������� ����������������� ������� � ����� ��������� ������
		int i=224;
		System.out.println("����� ����� ����� ������������ ����� " + i + " ����� " + sqrtInt (i));

		// 04 ��������� ��������� ����� n
		int x=4;
		double factorial;
		factorial = factorial (x);
		System.out.println("��������� ����� " + x + " ����� " + factorial);

		// 05 ��������� ����� ���� ��������� �����
		int n=123456789; 
		summ=0;
		summ= summOfDigits (n);
		System.out.println("����� ���� ����� "+ n + " ����� " + summ);

		// 06 ������� �����, ������� �������� ���������� ������������ 
		// ������������������ ���� ��������� �����
		int num =123456789, res;
		res = mirror (num);
		System.out.println("���������� ����������� ����� "+ num + " ����� " + res); 
	}

	// 01 ����� ����� ������ ����� � ��������� 1-99
	public static int summEven ()
	{
		int summ=0;
		for (int i=1; i<=99;i++)
		{
			if (i%2==0) 
			{
				summ+=i;
			}
		}
		return summ;
	}

	// 01 ����� ���������� ������ ����� � ��������� 1-99
	public static int countEven ()
	{
		int count=0;
		for (int i=1; i<=99;i++)
		{
			if (i%2==0) 
			{
				count++;
			}
		}
		return count;
	}

	// 02 ���������, ������� �� �����
	public static boolean isPrimeNumber (int x)
	{
		if (x<0) 
			throw new IllegalArgumentException();

		boolean ret= true;
		for (int y=2; y<=x/2; y++)
		{
			if (x%y==0)
			{
				ret = false;
				break;
			}
		}
		return ret;
	}

	// 03 ����� ������ ������������ ����� � ��������� �� ������
	// ����������� ������� ����������������� ������� � ����� ��������� ������
	public static int sqrtInt (int x)
	{
		if (x<0) 
			throw new IllegalArgumentException();

		int res=0;
		for (int i=0; i*i<=x; i++)
		{
			res = i;
		}
		return res;
	}

	// 04 ��������� ��������� ����� n
	public static double factorial (int x)
	{
		int factorial=1;
		if (x==0) 
			return 0;

		if (x>25) 
			throw new IllegalArgumentException();

		for (int i=1; i<=x; i++)
		{
			factorial = factorial*i;
		}
		return factorial;
	}

	// 05 ��������� ����� ���� ��������� �����
	public static int summOfDigits (int x)
	{
		if (x<0)
			x*=-1;

		int summ=0;
		while (x!=0)
		{
			summ += x%10;
			x/=10;
		}
		return summ;
	}

	// 06 ������� �����, ������� �������� ���������� ������������ 
	// ������������������ ���� ��������� �����
	public static int mirror (int x)
	{
		if (x<0) throw new IllegalArgumentException();

		String str = Integer.toString(x);
		String str2 = "";
		for (int i=str.length()-1; i>=0; i--)
		{
			str2 = str2 + str.charAt(i);
		}
		return Integer.parseInt(str2);
	}
}
