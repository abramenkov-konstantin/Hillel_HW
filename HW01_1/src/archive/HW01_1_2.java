package archive;

public class HW01_1_2 
{
	// 01 �������� ���������
	// 02 ���������� ����� ������� ������������ ����� 
	// ����������� (x,y)
	
	public static void main(String[] args) 
	{
		int x=0, y=0, res;
				
		res = quarter (x,y);
		
		System.out.print("����� � ������������ (" + x + "," + y +") ����������� " + res + " ��������");	
	}
	
	public static int quarter (int x, int y)
	{
		int res=0;
		if (x==0&y==0)
		{	
		res=0;
		}
		if(x>=0&y>=0)
		{
		res=1;
		} 
		if(x<0&y>=0)
		{
		res=2;
		}
		if(x<0&y<0)
		{
		res=3;
		}
		if(x>=0&y<0)
		{
		res=4;
		}
		return res;
	}
}
