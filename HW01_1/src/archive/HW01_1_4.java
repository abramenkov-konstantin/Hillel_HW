package archive;

public class HW01_1_4 
{
	// 01 условные операторы
	// 04 найти выражение макс(a*b*c, a+b+c)+3
	
	public static void main(String[] args) 
	{
		int a=8, b=2, c=1, res=0;
		
		res= max(a,b,c);
		
		System.out.println ("a = " + a);
		System.out.println ("b = " + b);
		System.out.println ("c = " + c);
		System.out.println ("макс(a*b*c, a+b+c)+3 = " + res);
	}
	
	public static int max (int a, int b, int c)
	{
		int res=0;
		if(a*b*c>=(a+b+c))
		{
			res=a*b*c+3;
		}
		else
		{
			res=a+b+c+3;
		}
		return res;
	}
}
