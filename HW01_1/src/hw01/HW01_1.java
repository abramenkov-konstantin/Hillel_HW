package hw01;

public class HW01_1 
{
	// 01 �������� ���������
	// 01 ���� � - ������ ��������� �*�, ����� �+�
	// 02 ���������� ����� ������� ������������ ����� c ������������ (x,y)
	// 03 ����� ����� ������ ������������� �� 3-� �����
	// 04 ����� ��������� ����(a*b*c, a+b+c)+3
	// 05 ����������� ������ �������� �� ��� ��������

	public static void main(String[] args) 
	{
		// 01 �������� ���������
		// 01 ���� � - ������ ��������� �*�, ����� �+�
		int a=3, b=3, res=0;
		res= func (a,b);
		System.out.println("a=" + a + ", b=" + b + ", res=" + res);

		// 01 �������� ���������
		// 02 ���������� ����� ������� ������������ ����� �
		// ������������ (x,y)
		int x=0, y=0;
		res = quarter (x,y);
		System.out.println("����� � ������������ (" + x + "," + y +") ����������� " + res + " ��������");

		// 01 �������� ���������
		// 03 ����� ����� ������ ������������� �� 3-� �����
		int num1=8, num2=-3, num3=6, summ=0;
		summ = summ3 (num1, num2, num3);
		System.out.println("num1=" + num1 + ", num2=" + num2 +", num3=" + num3 +", c���� ������������� ����� ����������:" + summ);

		// 01 �������� ���������
		// 04 ����� ��������� ����(a*b*c, a+b+c)+3
		int c=1;
		res= max(a,b,c);
		System.out.println ("a = " + a + ", b = " + b + ", c = " + c + ", ����(a*b*c, a+b+c)+3 = " + res);

		// 01 �������� ���������
		// 05 ����������� ������ �������� �� ��� ��������
		int rating=-1;
		char resch='0';
		resch = rate (rating);
		System.out.println("������� �������� =" + rating + ", ������ ��������:" + resch);



	}

	public static int func (int a, int b)
	{
		int res=0;
		if(a%2==0)
		{
			res = a*b;
		} 
		else
		{
			res=a+b;
		}
		return res;
	}

	public static int quarter (int x, int y)
	{
		int res = 0;
		if (x==0 || y==0)
		throw new IllegalArgumentException();

		if(x>0 && y>0)
		{
			res = 1;
		} 
		if(x<0 && y>0)
		{
			res = 2;
		}
		if(x< 0&& y<0)
		{
			res = 3;
		}
		if(x>0 && y<0)
		{
			res=4;
		}
		return res;
	}

	public static int summ3 (int n1, int n2, int n3)
	{
		int res = 0;
		if (n1>0)
		{
			res+=n1;
		}
		if (n2>0)
		{
			res+=n2;
		}
		if (n3>0)
		{
			res+=n3;
		}
		return res;
	}

	public static int max (int a, int b, int c)
	{
		int res = 0, pr = a*b*c, sm = a+b+c;

		if(pr>sm)
		{
			res=pr;
		}
		else
		{
			res=sm;
		}
		return res+3;
	}

	public static char rate (int rating)
	{
		if (rating<0 || rating>100)
		throw new IllegalArgumentException(); 
				
		char ret='0';
		if (rating>=0 && rating<=19)
		{	
			ret ='F';
		}
		else if(rating>=20 && rating<=39)
		{
			ret = 'E';
		} 
		else if(rating>=40 && rating<=59)
		{
			ret = 'D';
		}
		else if(rating>=60 && rating<=74)
		{
			ret = 'C';
		}
		else if(rating>=75 && rating<=89)
		{
			ret = 'B';
		}
		else if(rating>=90 && rating<=100)
		{
			ret = 'A';
		}
		else
		{
			ret = '0';
		}
		return ret;
	}
}	

