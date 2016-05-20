package archive;

public class HW01_2_5 
{
	// 02 циклы
	// 05 Посчитать сумму цифр заданного числа

	public static void main(String[] args) 
	{
		int n=123456789, summ=0;
		
		summ= summOfDigits (n);
		
		System.out.println("Сумма цифр числа "+ n + " равна: " + summ);
	
	}
		
        //char [] arr = str.toCharArray(); перегнать из строки в массив символов
		
	public static int summOfDigits (int x)
	{
		int summ=0;
		String str = Integer.toString(x);
		for (int i=0; i<=str.length()-1; i++)
		{
		summ += Character.getNumericValue(str.charAt(i));
		}
		return summ;
	}

}
