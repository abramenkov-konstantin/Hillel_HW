package hw01_3;

public class HW01_3
{	
	// 03 одномерные массивы
	// 03_01 найти минимальный элемент массива
	// 03_02 найти максимальный элемент массива
	// 03_03 найти индекс минимального элемент массива
	// 03_04 найти индекс максимального элемент массива
	// 03_05 посчитать сумму элементов массива с нечетными индексами
	// 03_06 сделать реверс массива
	// 03_07 посчитать количество нечетных элементов массива
	// 03_08 поменять местами первую и вторую половину массива
	// 03_09 отсортировать массив пузырьком, выбором, вставками 


	public static void main(String[] args)
	{
		//int size;
		//size=Integer.parseInt(JOptionPane.showInputDialog("Размер массива:"));
		int [] array = {1, 2, 3, 46, 54, 6, 7, 78};
		print(array, "Исходный массив:");

		//fill (array);
		int min = min (array);
		int max = max (array);
		int indexMin = indexMin (array);
		int indexMax = indexMax (array);
		int summOfOdd = sumOfOddIndex (array);
		int numOfOdd = numOfOdd (array);
		int [] arrayRevers = revers (array);
		int [] arraySwap = swap (array);
		int [] arrayBubble = sortBubble (array);
		int [] arraySelect = sortSelect (array);
		int [] arrayInsert = sortInsert (array);

		print(array, "\nЗаполненный массив:");
		System.out.println("\nЗначение минимального элемента:" + min);
		System.out.println("Значение максимального элемента:" + max);
		System.out.println("Индекс минимального элемента:" + indexMin);
		System.out.println("Индекс максимального элемента:" + indexMax);
		System.out.println("Сумма элементов массива c нечетными индексами:" + summOfOdd);
		System.out.println("Количество нечетных элементов массива:" + numOfOdd);
		print(arrayRevers, "\nРеверс массива");
		print(arraySwap, "\nПеревернутый массив");
		print(arrayBubble, "\nМассив, отсортированный методом пузырька");
		print(arraySelect, "\nМассив, отсортированный методом простого выбора");
		print(arrayInsert, "\nМассив, отсортированный методом вставки");
	}

	public static int[] fill (int[] array) //наполняем массив
	{	
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		for (int i=0; i<array.length; i++)
		{
			array[i] = (int)(100*Math.random()); 
		}
		return array;
	}


	public static void print(int [] array1, String str) //просматриваем массив
	{
		if (array1==null || array1.length == 0)
			throw new IllegalArgumentException();

		System.out.println(str);
		for (int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i] + " ");	
		}
	}

	// 03_01 найти минимальный элемент массива
	public static int min (int[] array) 
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		int min=array[0];
		for (int i=0; i<array.length; i++)
		{
			if (min>array[i])
			{
				min = array[i];	
			}
		}	
		return min;
	}

	// 03_02 найти максимальный элемент массива
	public static int max (int[] array) 
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();
		int max=array[0];
		for (int i=0; i<array.length; i++)
		{
			if (max<array[i])
			{
				max = array[i];	
			}
		}	
		return max;
	}

	// 03_03 найти индекс минимального элемент массива
	public static int indexMin (int[] array)
	{
		int indexMin=0;
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		for (int i=0; i<array.length; i++)
		{

			if (array[indexMin] > array[i])
			{
				indexMin = i;	
			}
		}
		return indexMin;
	}

	// 03_04 найти индекс максимального элемент массива
	public static int indexMax (int[] array)
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		int indexMax=0;
		for (int i=0; i<array.length; i++)
		{
			if (array[indexMax] < array[i])
			{
				indexMax = i;	  
			}
		}
		return indexMax;
	}

	public static int sumOfOddIndex (int[] array) //суммируем нечетные элементы
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		int summOfOdd=0;
		for (int i=0; i<array.length; i++)
		{

			if(i%2!=0)
			{
				summOfOdd+=array[i]; 
			}
		}
		return summOfOdd;
	}

	// 03_05 посчитать сумму элементов массива с нечетными индексами
	public static int numOfOdd (int[] array) 
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();
		int numOfOdd=0;
		for (int i=0; i<array.length; i++)
		{
			if(array[i]%2!=0)
			{
				numOfOdd++;	
			}
		}
		return numOfOdd;
	}

	// 03_06 сделать реверс массива
	public static int [] revers (int[] array) // реверс массива
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		int[] reversearr = new int[array.length];
		for (int i = 0; i <= array.length - 1; i++) 
		{
			reversearr[i] = array[array.length - 1 - i];
		}
		return reversearr;
	}		

	// 03_07 посчитать количество нечетных элементов массива
	// 03_08 поменять местами первую и вторую половину массива



	public static int[] swap(int[] array) 
	{
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		int[] swap = new int[array.length];
		if (array.length % 2 != 0) {
			for (int i = 0; i < array.length / 2; i++) 
			{
				swap[i] = array[(array.length + 1) / 2 + i];
				swap[(array.length + 1) / 2 + i] = array[i];
			}
			swap[(array.length/2)] = array[(array.length/2)];
		}
		if (array.length % 2 == 0) {
			for (int i = 0; i < array.length / 2; i++) 
			{
				swap[i] = array[(array.length / 2) + i];
				swap[(array.length / 2) + i] = array[i];
			}
		}
		return swap;
	}
	// 03_09 отсортировать массив пузырьком
	public static int [] sortBubble (int[] arrayBubble)
	{
		if (arrayBubble==null || arrayBubble.length == 0)
			throw new IllegalArgumentException();

		for(int i=0;i<arrayBubble.length;i++)					
		{
			for(int j=0;j<arrayBubble.length-i-1;j++)
			{
				if(arrayBubble[j]>arrayBubble[j+1])  
				{
					int tmp=arrayBubble[j+1];	 
					arrayBubble[j+1]=arrayBubble[j];
					arrayBubble[j]=tmp;
				}
			}
		}
		return arrayBubble;			
	}

	// 03_09 отсортировать массив выбором
	public static int [] sortSelect (int[] arraySelect)
	{
		if (arraySelect==null || arraySelect.length == 0)
			throw new IllegalArgumentException();

		for (int i=0;i<arraySelect.length;i++) 
		{
			int indexmin=i;
			for (int j=i; j<arraySelect.length;j++)
			{
				if (arraySelect[indexmin]>arraySelect[j])
				{
					indexmin = j;
				}
			}
			int tmp=arraySelect[i]; 
			arraySelect[i]=arraySelect[indexmin];
			arraySelect[indexmin]=tmp;
		}
		return arraySelect;			
	}

	// 03_09 отсортировать массив вставками
	public static int [] sortInsert (int[] arrayIns)
	{
		if (arrayIns==null || arrayIns.length==0)
			throw new IllegalArgumentException();

		for(int i=1; i<arrayIns.length; i++)
		{
			int currElem=arrayIns[i];
			int prevIndex=i-1;
			while(prevIndex>=0 && arrayIns[prevIndex]>currElem)
			{
				arrayIns[prevIndex+1]=arrayIns[prevIndex];
				arrayIns[prevIndex]=currElem;
				prevIndex--;
			}
		}
		return arrayIns;			
	}

}
