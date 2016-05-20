package HW01_2;

public class HW01_2 
{
	// 02 циклы
	// 01 найти сумму четных чисел и их количество в диапазоне 1-99
	// 02 проверить, простое ли число
	// 03 найти корень натурального числа с точностью до целого
	// рассмотреть вариант последовательного подбора и метод бинарного поиска
	// 04 вычислить факториал числа n
	// 05 Посчитать сумму цифр заданного числа
	// 06 вывести число, которое является зеркальным отображением 
	// последовательности цифр заданного числа

	public static void main(String[] args) 
	{
		// 01 найти сумму четных чисел и их количество в диапазоне 1-99
		int summ=0, count=0;
		summ = summEven ();
		count = countEven ();
		System.out.println ("Сумма четных чисел в диапазоне [1,99] равна "+ summ);
		System.out.println ("Количество четных чисел в диапазоне [1,99] равно " + count);

		// 02 проверить, простое ли число
		int a=4;
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

		// 03 найти корень натурального числа с точностью до целого
		// рассмотреть вариант последовательного подбора и метод бинарного поиска
		int i=224;
		System.out.println("Целая часть корня натурального числа " + i + " равна " + sqrtInt (i));

		// 04 вычислить факториал числа n
		int x=4;
		double factorial;
		factorial = factorial (x);
		System.out.println("Факториал числа " + x + " равен " + factorial);

		// 05 Посчитать сумму цифр заданного числа
		int n=123456789; 
		summ=0;
		summ= summOfDigits (n);
		System.out.println("Сумма цифр числа "+ n + " равна " + summ);

		// 06 вывести число, которое является зеркальным отображением 
		// последовательности цифр заданного числа
		int num =123456789, res;
		res = mirror (num);
		System.out.println("Зеркальное отображение числа "+ num + " равно " + res); 
	}

	// 01 найти сумму четных чисел в диапазоне 1-99
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

	// 01 найти количество четных чисел в диапазоне 1-99
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

	// 02 проверить, простое ли число
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

	// 03 найти корень натурального числа с точностью до целого
	// рассмотреть вариант последовательного подбора и метод бинарного поиска
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

	// 04 вычислить факториал числа n
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

	// 05 Посчитать сумму цифр заданного числа
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

	// 06 вывести число, которое является зеркальным отображением 
	// последовательности цифр заданного числа
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
