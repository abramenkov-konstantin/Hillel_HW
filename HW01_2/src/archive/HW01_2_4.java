package archive;

public class HW01_2_4 
{
	// 02 �����
	// 04 ��������� ��������� ����� n
	
	public static void main(String[] args) 
	{
		int x=4, factorial;
	
		factorial = factorial (x);
				
		System.out.println("��������� ����� " + x + " �����: " + factorial);
	}
	
	public static int factorial (int x)
	{
		int factorial=1;
		for (int i=1; i<=x; i++)
		{
			factorial = factorial*i;
		}
		return factorial;
	}
}
