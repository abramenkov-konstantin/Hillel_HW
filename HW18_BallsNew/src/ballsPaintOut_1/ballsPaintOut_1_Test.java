package ballsPaintOut_1;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import org.junit.Test;

public class ballsPaintOut_1_Test 
{
	public boolean isChanged(double d1, double d2)
	{
		boolean res = false;
		if ((Math.signum(d1)>0 && Math.signum(d2)>0) || (Math.signum(d1)<0 && Math.signum(d2)<0) )
			res = true;
		if ((Math.signum(d1)>0 && Math.signum(d2)<0) || (Math.signum(d1)<0 && Math.signum(d2)>0) )
			res = false;
		return res;
	}

	@Test
	public void testdDrection01()
	{
		ArrayList<Ball> balls = new ArrayList<>();
		double dx0=10;
		double dy0=10;
		double dx1=10;
		double dy1=-10;

		balls.add (new Ball(200, 200, dx0, dy0 , 50)) ;
		balls.add (new Ball(201, 250, dx1, dy1 , 50)) ;
		
		
		new XFrame().add( new XPanel() );
		Dimension dd = getSize();
		
		for (int i = 0; i< balls.size(); i++)
		{
			//check collision with walls
			if(checkXWallCollision(balls.get(i), dd))
			{
				balls.get(i).dx = -balls.get(i).dx;
			}

			if(checkYWallCollision(balls.get(i), dd))
			{
				balls.get(i).dy = -balls.get(i).dy;
			}

			for (int j=i; j < balls.size(); j++)
			{
				//check collision with other balls
				Point p = checkBallsCollision(balls.get(i), balls.get(j));
				if ( i!=j && p!=null)
				{
					//calculate reflection
					Point p1 = calculateBallReflection(balls.get(i), p);
					Point p2 = calculateBallReflection(balls.get(j), p);

					//set reflection
					balls.get(i).dx = p1.x;
					balls.get(i).dy = p1.y;
					balls.get(j).dx = p2.x;
					balls.get(j).dy = p2.y;
					p = null;
				}
			}
		}
		
		//move and repaint balls
		for (Ball b: balls)
		{
			b.x+=b.dx;
			b.y+=b.dy;
			b.paint(gg);
		}
		
		
		
		for (int i=0; i<20; i++)
		{	
		}

		System.out.println(dx0 + " " + dx1 + " " + dy0 + " " + dy1);
		System.out.println(balls.get(0).dx + " " + balls.get(1).dx + " " + balls.get(0).dy + " " + balls.get(1).dy);
	
		assertTrue(isChanged(dx0, balls.get(0).dx));
		assertTrue(isChanged(dx1, balls.get(1).dx));
		assertTrue(isChanged(dy0, balls.get(0).dy));
		assertTrue(isChanged(dy1, balls.get(1).dy));
	}

	@Test
	public void testdDrection02()
	{
		ArrayList<Ball> balls = new ArrayList<>();

		new XFrame();
		
		int dx0=-10;
		int dy0=10;
		int dx1=-10;
		int dy1=-10;
		balls.add (new Ball(200, 200, dx0, dy0 , 50)) ;
		balls.add (new Ball(201, 250, dx1, dy1 , 50)) ;

		
		for (int i=0; i<15; i++)
		{	
		
		}
		System.out.println(dx0 + " " + dx1 + " " + dy0 + " " + dy1);
		System.out.println(balls.get(0).dx + " " + balls.get(1).dx + " " + balls.get(0).dy + " " + balls.get(1).dy);
		
		assertTrue(isChanged(dx0, balls.get(0).dx));
		assertTrue(isChanged(dx1, balls.get(1).dx));
		assertTrue(isChanged(dy0, balls.get(0).dy));
		assertTrue(isChanged(dy1, balls.get(1).dy));
	}



}
