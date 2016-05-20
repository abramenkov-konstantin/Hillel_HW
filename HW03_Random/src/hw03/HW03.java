package hw03;

public class HW03 
{
	// Тема: случайные числа - генератор случайных чисел
	// 01 Вывести на консоль случайное число
	// 02 Вывести на консоль 10 случайных чисел
	// 03 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от 0 до 10
	// 04 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от 20 до 50
	// 05 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от -10 до 10
	// 06 Вывести на консоль случайное количество 
	//    (в диапазоне от 3 до 5) случайных чисел, 
	//    каждое в диапазоне от -10 до 35

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

	// 01 Вывести на консоль случайное число
	public static void rand1()
	{	
		System.out.println("1 задача");
		System.out.print(Math.random());
	}

	// 02 Вывести на консоль 10 случайных чисел
	public static void rand2()
	{	
		System.out.println("2 задача");
		for (int i=1; i<10; i++)
		{
			System.out.print(Math.random() + " ");
		}
	}

	// 03 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от 0 до 10
	public static void rand3()
	{	
		System.out.println("3 задача");
		for (int i=1; i<10; i++)
		{
			System.out.print((int) (10*Math.random()) + " ");
		}
	}

	// 04 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от 20 до 50
	public static void rand4()
	{	
		System.out.println("4 задача");
		int rnd;
		for (int i=1; i<10; i++)
		{
			rnd = 20 + (int)(Math.random()*31);
			System.out.print(rnd + " ");
		}
	}

	// 05 Вывести на консоль 10 случайных чисел, 
	//    каждое в диапазоне от -10 до 10
	public static void rand5()
	{	
		System.out.println("5 задача");
		int rnd;
		for (int i=1; i<10; i++)
		{
			rnd = -10 + (int)(Math.random()*21);
			System.out.print(rnd + " ");
		}
	}

	// 06 Вывести на консоль cлучайное количество 
	//    (в диапазоне от 3 до 5) случайных чисел, 
	//    каждое в диапазоне от -10 до 35
	public static void rand6()
	{	
		int rnd1, rnd2, kolmin=3, kolmax=5, min=-10, max=35;
		rnd1 = kolmin + (int)(Math.random() * ((kolmax - kolmin) + 1));
		System.out.println("6 задача");
		for (int i=1; i<=rnd1; i++)
		{
			rnd2 = min + (int)(Math.random() * ((max - min) + 1));
			System.out.print(rnd2 + " ");
		}
	}
}
