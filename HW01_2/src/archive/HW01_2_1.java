package archive;

public class HW01_2_1 
{
	// 02 �����
	// 01 ����� ����� ������ ����� � �� ���������� � ��������� 1-99

	public static void main(String[] args) 
	{
		int x=1, y=100, summ=0, count=0;
		
		summ= summEven (x,y);
		count= countEven (x,y);
		
		System.out.println ("����� ������ ����� � ��������� [" + x + "," + y + "] �����: "+ summ);
		System.out.println ("���������� ������ ����� � ��������� [" + x + "," + y + "] �����: " + count);
	}
	
	public static int summEven (int x, int y)
	{
		int summ=0;
		for (int i=x; i<=y;i++)
		{
			if (i%2==0) 
			{
				summ=summ+i;
			}
		}
		return summ;
	}
	
	public static int countEven (int x, int y)
	{
		int count=0;
		for (int i=x; i<=y;i++)
		{
			if (i%2==0) 
			{
				count++;
			}
		}
		return count;
	}

}
