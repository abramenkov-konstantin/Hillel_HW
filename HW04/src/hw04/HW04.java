package hw04;
import static java.lang.Math.*;

public class HW04 
{
	// Тема: библиотека Math

	// 01 Стрельба из гаубицы. Дан угол возвышения ствола а 
	//    и начальная скорость полета снаряда v км/ч.
	//    Вычислить расстояние полета снаряда.
	//    Реализовать решение для угла в градусах и радианах.

	// 02 Скорость первого автомобиля v1 км/ч, второго v2 км/ч
	//    расстояние между ними s км.
	//    Какое расстояние будет между ними через t часов, если
	//    автомобили движутся в разные стороны.

	// 03 Записать логическое выражение, принимающее значение 1,
	//    если точка лежит внутри заштрихованной области, иначе 0

	// 04 Вычислить значение выражения




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

	// 01 Стрельба из гаубицы. Дан угол возвышения ствола а 
	//    и начальная скорость полета снаряда v км/ч.
	//    Вычислить расстояние полета снаряда.
	//    Реализовать решение для угла в градусах и радианах.
	public static double distShoot (double v, double angle)
	{
		if (v<=0. || angle <= 0.)
			throw new IllegalArgumentException();

		double res=0;
		res = (pow (v,2) *  sin(toRadians(2*angle))/ 9.8);
		return res;
	}

	// 02 Скорость первого автомобиля v1 км/ч, второго v2 км/ч
	//    расстояние между ними s км.
	//    Какое расстояние будет между ними через t часов, если
	//    автомобили движутся в разные стороны.
	public static double distAuto (double v1, double v2, double t, double s)
	{
		if (v1<=0. || v2 <= 0. || t <= 0. || s <= 0.)
			throw new IllegalArgumentException();

			return s + v1*t + v2*t;
	}

	// 03 Записать логическое выражение, принимающее значение 1,
	//    если точка лежит внутри заштрихованной области, иначе 0
	public static boolean area(double x, double y)
	{
		boolean res=false;
		if ((x>=0 && y<=x && y>=(1.5*x - 1)) || ((x<0 && y<=-x && y>=-1.5*x - 1)))
			res = true;
		return res;
	}

	// 04 Вычислить значение выражения
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
