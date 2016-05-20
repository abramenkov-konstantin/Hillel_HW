package hw03;

public class HW03 
{
	// ����: ��������� ����� - ��������� ��������� �����
	// 01 ������� �� ������� ��������� �����
	// 02 ������� �� ������� 10 ��������� �����
	// 03 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� 0 �� 10
	// 04 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� 20 �� 50
	// 05 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� -10 �� 10
	// 06 ������� �� ������� ��������� ���������� 
	//    (� ��������� �� 3 �� 5) ��������� �����, 
	//    ������ � ��������� �� -10 �� 35

	public static void main(String[] args) 
	{
		rand1();
		System.out.println("\n");
		rand2();
		System.out.println("\n");
		rand3();
		System.out.println("\n");
		rand4();
		System.out.println("\n");
		rand5();
		System.out.println("\n");
		rand6();
	}

	// 01 ������� �� ������� ��������� �����
	public static void rand1()
	{	
		System.out.println("1 ������");
		System.out.print(Math.random());
	}

	// 02 ������� �� ������� 10 ��������� �����
	public static void rand2()
	{	
		System.out.println("2 ������");
		for (int i=1; i<10; i++)
		{
			System.out.print(Math.random() + " ");
		}
	}

	// 03 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� 0 �� 10
	public static void rand3()
	{	
		System.out.println("3 ������");
		for (int i=1; i<10; i++)
		{
			System.out.print((int) (10*Math.random()) + " ");
		}
	}

	// 04 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� 20 �� 50
	public static void rand4()
	{	
		System.out.println("4 ������");
		int rnd;
		for (int i=1; i<10; i++)
		{
			rnd = 20 + (int)(Math.random()*31);
			System.out.print(rnd + " ");
		}
	}

	// 05 ������� �� ������� 10 ��������� �����, 
	//    ������ � ��������� �� -10 �� 10
	public static void rand5()
	{	
		System.out.println("5 ������");
		int rnd;
		for (int i=1; i<10; i++)
		{
			rnd = -10 + (int)(Math.random()*21);
			System.out.print(rnd + " ");
		}
	}

	// 06 ������� �� ������� c�������� ���������� 
	//    (� ��������� �� 3 �� 5) ��������� �����, 
	//    ������ � ��������� �� -10 �� 35
	public static void rand6()
	{	
		int rnd1, rnd2, kolmin=3, kolmax=5, min=-10, max=35;
		rnd1 = kolmin + (int)(Math.random() * ((kolmax - kolmin) + 1));
		System.out.println("6 ������");
		for (int i=1; i<=rnd1; i++)
		{
			rnd2 = min + (int)(Math.random() * ((max - min) + 1));
			System.out.print(rnd2 + " ");
		}
	}
}
