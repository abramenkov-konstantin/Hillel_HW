package archive;

public class HW01_2_3 
{
	// 02 циклы
	// 03 найти корень натурального числа с точностью до целого
	// рассмотреть вариант последовательного подбора и метод бинарного поиска

	public static void main(String[] args) 
	{
		int i=224, res;
		
		res = sqrtInt (i);
				
		System.out.println(res);
	}
	
	public static int sqrtInt (int x)
	{
		int res=0;
		for (int i=0; i*i<=x; i++)
		{
			res = i;
		}
		return res;
	}

}
