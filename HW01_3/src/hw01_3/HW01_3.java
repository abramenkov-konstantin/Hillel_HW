package hw01_3;

public class HW01_3
{	
	// 03 ���������� �������
	// 03_01 ����� ����������� ������� �������
	// 03_02 ����� ������������ ������� �������
	// 03_03 ����� ������ ������������ ������� �������
	// 03_04 ����� ������ ������������� ������� �������
	// 03_05 ��������� ����� ��������� ������� � ��������� ���������
	// 03_06 ������� ������ �������
	// 03_07 ��������� ���������� �������� ��������� �������
	// 03_08 �������� ������� ������ � ������ �������� �������
	// 03_09 ������������� ������ ���������, �������, ��������� 


	public static void main(String[] args)
	{
		//int size;
		//size=Integer.parseInt(JOptionPane.showInputDialog("������ �������:"));
		int [] array = {1, 2, 3, 46, 54, 6, 7, 78};
		print(array, "�������� ������:");

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

		print(array, "\n����������� ������:");
		System.out.println("\n�������� ������������ ��������:" + min);
		System.out.println("�������� ������������� ��������:" + max);
		System.out.println("������ ������������ ��������:" + indexMin);
		System.out.println("������ ������������� ��������:" + indexMax);
		System.out.println("����� ��������� ������� c ��������� ���������:" + summOfOdd);
		System.out.println("���������� �������� ��������� �������:" + numOfOdd);
		print(arrayRevers, "\n������ �������");
		print(arraySwap, "\n������������ ������");
		print(arrayBubble, "\n������, ��������������� ������� ��������");
		print(arraySelect, "\n������, ��������������� ������� �������� ������");
		print(arrayInsert, "\n������, ��������������� ������� �������");
	}

	public static int[] fill (int[] array) //��������� ������
	{	
		if (array==null || array.length == 0)
			throw new IllegalArgumentException();

		for (int i=0; i<array.length; i++)
		{
			array[i] = (int)(100*Math.random()); 
		}
		return array;
	}


	public static void print(int [] array1, String str) //������������� ������
	{
		if (array1==null || array1.length == 0)
			throw new IllegalArgumentException();

		System.out.println(str);
		for (int i=0; i<array1.length; i++)
		{
			System.out.print(array1[i] + " ");	
		}
	}

	// 03_01 ����� ����������� ������� �������
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

	// 03_02 ����� ������������ ������� �������
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

	// 03_03 ����� ������ ������������ ������� �������
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

	// 03_04 ����� ������ ������������� ������� �������
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

	public static int sumOfOddIndex (int[] array) //��������� �������� ��������
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

	// 03_05 ��������� ����� ��������� ������� � ��������� ���������
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

	// 03_06 ������� ������ �������
	public static int [] revers (int[] array) // ������ �������
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

	// 03_07 ��������� ���������� �������� ��������� �������
	// 03_08 �������� ������� ������ � ������ �������� �������



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
	// 03_09 ������������� ������ ���������
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

	// 03_09 ������������� ������ �������
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

	// 03_09 ������������� ������ ���������
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
