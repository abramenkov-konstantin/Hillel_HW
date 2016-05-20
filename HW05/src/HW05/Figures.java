package HW05;

public class Figures 
{
	public static void main(String[] args) 
	{
		stars00();
		stars01();
		stars02();
		stars03();
		stars04();
		stars05();
		stars06();
		stars07();
		stars08();
		stars09();
		stars10();

		digits01();
		digits02();
		digits03();
		digits04();

	}
	public static void stars00 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars01 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==1 || j==1 || i==7 || j==7) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars02 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==1 || j==1 || i+j==8) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars03 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==7 || j==1 || i==j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars04 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==7 || j==7 || i+j==8) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars05 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==1 || j==7 || i==j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars06 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i+j==8 || i==j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars07 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==1 || j==i&&i<=4 || i+j==8&&i<=4) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void stars08 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(j==1 || j==i&&j<=4 || i+j==8&&j<=4) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars09 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(j==7 || j==i&&j>=4 || i+j==8&&j>=4) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void stars10 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				if(i==7 || j==i&&i>=4 || i+j==8&&i>=4) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void digits01 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				System.out.print(i);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void digits02 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				System.out.print(8-i);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void digits03 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void digits04 ()
	{
		for (int i=1; i<=7; i++)
		{
			for (int j=1; j<=7;j++)
			{
				System.out.print(8-j);
			}
			System.out.println();
		}
		System.out.println();
	}
}
