package archive;

public class HW01_2_3 
{
	// 02 �����
	// 03 ����� ������ ������������ ����� � ��������� �� ������
	// ����������� ������� ����������������� ������� � ����� ��������� ������

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
