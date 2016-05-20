package archive;

public class HW01_2_6 
{
	// 02 циклы
	// 06 вывести число, которое является зеркальным отображением 
	// последовательности цифр заданного числа

	public static void main(String[] args) 
	{
		int x =123456789, res;
		
		res = mirror (x);
		
		System.out.println(x + "  " + res); 
	}
	
	public static int mirror (int x)
	{
		String str = Integer.toString(x);
		String str2 = "";
		for (int i=str.length()-1; i>=0; i--)
		{
			str2 = str2 + str.charAt(i);
		}
		return Integer.parseInt(str2);
	}
	
	
}
