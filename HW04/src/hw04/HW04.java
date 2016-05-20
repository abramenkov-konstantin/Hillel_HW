package hw04;
import static java.lang.Math.*;

public class HW04 
{
	// ����: ���������� Math

	// 01 �������� �� �������. ��� ���� ���������� ������ � 
	//    � ��������� �������� ������ ������� v ��/�.
	//    ��������� ���������� ������ �������.
	//    ����������� ������� ��� ���� � �������� � ��������.

	// 02 �������� ������� ���������� v1 ��/�, ������� v2 ��/�
	//    ���������� ����� ���� s ��.
	//    ����� ���������� ����� ����� ���� ����� t �����, ����
	//    ���������� �������� � ������ �������.

	// 03 �������� ���������� ���������, ����������� �������� 1,
	//    ���� ����� ����� ������ �������������� �������, ����� 0

	// 04 ��������� �������� ���������




	public static void main(String[] args) 
	{
		double speed=100, angleDegree=45;
		double distanceShoot=0;
		distanceShoot = distShoot (speed, angleDegree);
		System.out.println(distanceShoot);


		double v1=20, v2=20, t=2, s=20;
		double distanceAuto=0;
		distanceAuto = distAuto (v1, v2, t, s);
		System.out.println(distanceAuto);

		double x=2., y=2.;
		boolean inArea;
		inArea = area(x,y);
		System.out.println(inArea);

		x=0;
		double resfunc;
		resfunc = func(x);
		System.out.println(resfunc);



	}

	// 01 �������� �� �������. ��� ���� ���������� ������ � 
	//    � ��������� �������� ������ ������� v ��/�.
	//    ��������� ���������� ������ �������.
	//    ����������� ������� ��� ���� � �������� � ��������.
	public static double distShoot (double v, double angle)
	{
		if (v<=0. || angle <= 0.)
			throw new IllegalArgumentException();

		double res=0;
		res = (pow (v,2) *  sin(toRadians(2*angle))/ 9.8);
		return res;
	}

	// 02 �������� ������� ���������� v1 ��/�, ������� v2 ��/�
	//    ���������� ����� ���� s ��.
	//    ����� ���������� ����� ����� ���� ����� t �����, ����
	//    ���������� �������� � ������ �������.
	public static double distAuto (double v1, double v2, double t, double s)
	{
		if (v1<=0. || v2 <= 0. || t <= 0. || s <= 0.)
			throw new IllegalArgumentException();

			return s + v1*t + v2*t;
	}

	// 03 �������� ���������� ���������, ����������� �������� 1,
	//    ���� ����� ����� ������ �������������� �������, ����� 0
	public static boolean area(double x, double y)
	{
		boolean res=false;
		if ((x>=0 && y<=x && y>=(1.5*x - 1)) || ((x<0 && y<=-x && y>=-1.5*x - 1)))
			res = true;
		return res;
	}

	// 04 ��������� �������� ���������
	public static double func(double x)
	{
		double num1, num2, denom1, denom2;

		num1 = 6 *  log(pow(E,(x+1)) + 2*pow(E,x)*cos(x));
		num2 = cos(x);
		denom1 = log(x - pow(E, (x+1)) * sin(x));
		denom2 = pow(E, sin(x));

		if (denom1==0 ||denom2==0)
			throw new ArithmeticException();

		return num1/denom1 + abs(num2/denom2);

		//return (6*Math.log(Math.pow(Math.E,(x+1))+2*Math.pow(Math.E,x)*Math.cos(x)))/(Math.log(x-Math.pow(Math.E,(x+1))*Math.sin(x)))+Math.abs((Math.cos(x))/(Math.pow(Math.E,Math.sin(x))));
	}
}
