package ballsPaintOut_1;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class XPanel extends JPanel implements MouseListener
{
	private static final long serialVersionUID = 1L;
	ArrayList<Ball> balls = new ArrayList<>();

	public XPanel() 
	{
		setLayout(null);
		addMouseListener(this);
		Thread tm = new Thread(new TAction());
		tm.start();
		
		balls.add (new Ball(100, 100, 5, 5 , 50)) ;
		balls.add (new Ball(101, 300, 5, -5 , 50)) ;
		
		//balls.add (new Ball(400, 250, 0, 0 , 100) );
	}

	class TAction implements Runnable
	{
		@Override
		public void run() 
		{int  i=0;
			try 
			{
				while(true)
				{
					repaint();
					Thread.sleep(50);
					System.out.println(i++);
					
				}
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public void paint (Graphics g)
	{
		Graphics2D gg = (Graphics2D) g;
		super.paint(gg);
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
	}


	public boolean checkXWallCollision(Ball ball, Dimension dd)
	{
		boolean res=false;
		if (ball.x <= ball.radius || ball.x + ball.radius >= dd.getWidth())
			res=true;
		return res;
	}

	public boolean checkYWallCollision(Ball ball, Dimension dd)
	{
		boolean res=false;
		if (ball.y <= ball.radius || ball.y + ball.radius >= dd.getHeight()  )
			res=true;
		return res;
	}

	public Point checkBallsCollision(Ball ball1, Ball ball2)
	{
		Point p=null;
		double x1= ball1.x, y1= ball1.y, radius1=ball1.radius;
		double x2= ball2.x, y2= ball2.y, radius2=ball2.radius;

		double ddx = Math.max(x1, x2) - Math.min(x1, x2);
		double ddy = Math.max(y1, y2) - Math.min(y1, y2);
		double distance = Math.sqrt(ddx*ddx + ddy*ddy);
		double sumradius = radius1 + radius2;

		//расстояние от центра шара до точки столкновения
		double ddx1 = (ddx*radius1)/ distance;
		double ddy1 = (ddy*radius1)/ distance;
		double px, py;

		if (distance>0 && distance <= sumradius)
		{
			px = Math.max(x1, x2) - ddx1;
			py = Math.max(y1, y2) - ddy1;
			System.out.println("Collision: dist = " + distance +  ", sumrad = " + sumradius + ".");
			System.out.println("[x1, y1] = [" + x1 + ", " + y1 + "], [x2, y2] = ["
					+ x2 + ", " + y2 + "], [px, py] = [" + px + ", " + py + "].");
			p = new Point ();
			p.setLocation(px, py);
		}		
		return p;
	}

	public Point calculateBallReflection(Ball ball, Point p)
	{
		double x= ball.x, y= ball.y, ax= ball.dx, ay = ball.dy, newDx=0, newDy=0;
		double px= p.getX(), py= p.getY();
		double speedVectorLength;
		double chisl = ax*(px-x) + ay*(py-y);
		double znam = Math.sqrt(ax*ax + ay*ay)*Math.sqrt((px-x)*(px-x) + (py-y)*(py-y));
		double cosAngle=0;
		if (znam!=0) cosAngle = chisl/znam;
		double angle = Math.toDegrees(Math.acos(cosAngle));//угол между вектором скорости и радиусом
		speedVectorLength = Math.sqrt(ax*ax + ay*ay);      //длина вектора скорости
		System.out.println("For ball [" + x  + ", "+ y + "], угол = " + angle 
				+ " градусов, Вектор скорости [" + ax  + ", "+ ay 
				+ "], длина вектора = " + speedVectorLength);

		//double newAbsDx = ax*cosAngle;
		//double newAbsDy = Math.sqrt(speedVectorLength*speedVectorLength - newAbsDx*newAbsDx);

		double newAbsDx = ax;
		double newAbsDy = ay;

		if (px==x)
		{
			newDy = - newAbsDy;
			newDx =  newAbsDx;
		}
		else if (py==y)
		{
			newDx = - newAbsDx;
			newDy = newAbsDy;
		}
		else if ((ax>0 && ay<0 && px>x && py<y) ||  (ax>0 && ay>0 && px>x && py>y) || 
				(ax<0 && ay>0 && px<x && py>y) || (ax<0 && ay<0 && px<x && py<y))
		{
			newDx = - newAbsDx;
			newDy = - newAbsDy;
		}
		else if ((ax>0 && ay<0 && px>x && py>y) || (ax>0 && ay>0 && px>x && py<y) || 
				(ax<0 && ay>0 && px<x && py<y) || (ax<0 && ay<0 && px<x && py>y))
		{
			newDx = -newAbsDx;
			newDy = newAbsDy;
		}
		else if ((ax>0 && ay<0 && px<x && py<y) || (ax>0 && ay>0 && px<x && py>y) || 
				(ax<0 && ay>0 && px>x && py>y) || (ax<0 && ay<0 && px>x && py<y))
		{
			newDx =  newAbsDx;
			newDy =  -newAbsDy;
		}
		else
		{
			newDx =  newAbsDx;
			newDy =  newAbsDy;
		}

		Point pDx = new Point ();
		pDx.setLocation(newDx, newDy);
		return pDx;

		//то же самое , но подробно
		/*if (ax>0 && ay<0) //1,2
		{
			if (px>x && py<y)
			{
				newDx = - newAbsDx;
				newDy = - newAbsDy;
			}
			else if (px>x && py>y)
			{
				newDx = -newAbsDx;
				newDy = newAbsDy;
			}
			else if (px<x && py<y)
			{
				newDx =  newAbsDx;
				newDy =  -newAbsDy;
			}
			else
			{
				newDx =  newAbsDx;
				newDy =  newAbsDy;
			}
		}
		else if (ax>0 && ay>0) //3,4
		{
			if (px>x && py>y)
			{
				newDx = - newAbsDx;
				newDy = - newAbsDy;
			}
			else if (px>x && py<y)
			{
				newDx = -newAbsDx;
				newDy =   newAbsDy;
			}
			else if (px<x && py>y)
			{
				newDx =  newAbsDx;
				newDy =  -newAbsDy;
			}
			else
			{
				newDx =  newAbsDx;
				newDy =  newAbsDy;
			}
		}
		else if (ax<0 && ay>0) //5,6
		{
			if (px<x && py>y)
			{
				newDx = - newAbsDx;
				newDy = - newAbsDy;
			}
			else if (px<x && py<y)
			{
				newDx = -newAbsDx;
				newDy =   newAbsDy;
			}
			else if (px>x && py>y)
			{
				newDx =  newAbsDx;
				newDy =  -newAbsDy;
			}
			else
			{
				newDx =  newAbsDx;
				newDy =  newAbsDy;
			}
		}
		else if (ax<0 && ay<0) //7,8
		{
			if (px<x && py<y)
			{
				newDx = - newAbsDx;
				newDy = - newAbsDy;
			}
			else if (px>x && py<y)
			{
				newDx = newAbsDx;
				newDy = -newAbsDy;
			}
			else if (px<x && py>y)
			{
				newDx =  -newAbsDx;
				newDy =  newAbsDy;
			}
			else
			{
				newDx =  newAbsDx;
				newDy =  newAbsDy;
			}
		}*/
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if (e.getModifiers()== InputEvent.BUTTON1_MASK)
		{
			Dimension dd =  getSize();
			int maxRadius =(int) Math.min(Math.min (e.getX(), e.getY()), Math.min(dd.getWidth()-e.getX(), dd.getHeight()-e.getY()));
			int count=0;


			for (int i=0; i< balls.size(); i++)
			{
				double ddx = (Math.max(e.getX(), balls.get(i).x) - Math.min(e.getX(), balls.get(i).x));
				double ddy = (Math.max(e.getY(), balls.get(i).y) - Math.min(e.getY(), balls.get(i).y));
				double distance = Math.sqrt(ddx*ddx + ddy*ddy);
				double maxLocalRadius = distance - balls.get(i).radius;

				if (    (e.getX() >= balls.get(i).x - balls.get(i).radius) && 
						(e.getX() <= balls.get(i).x + balls.get(i).radius) &&
						(e.getY() >= balls.get(i).y - balls.get(i).radius) && 
						(e.getY() <= balls.get(i).y + balls.get(i).radius)    )
					count++;
				
				if (maxLocalRadius < maxRadius)
				{
					maxRadius = (int) maxLocalRadius;
				}
									
			}
			if (count==0 && maxRadius>30)
			{
								
				balls.add (new Ball(e.getX(), e.getY(), maxRadius)) ;
				//balls.add (new Ball(e.getX(), e.getY(), -5, -5 , 70) ) ;
			}
		}
		else if
		(e.getModifiers()==InputEvent.BUTTON3_MASK)
		{
			for (int i=0; i< balls.size(); i++)
			{
				if (    (e.getX() >= balls.get(i).x - balls.get(i).radius) && 
						(e.getX() <= balls.get(i).x + balls.get(i).radius) &&
						(e.getY() >= balls.get(i).y - balls.get(i).radius) && 
						(e.getY() <= balls.get(i).y + balls.get(i).radius)    )
					balls.remove(i);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getModifiers()==InputEvent.BUTTON3_MASK)
		{
			for (int i=0; i< balls.size(); i++)
			{
				if (    (e.getX() >= balls.get(i).x - balls.get(i).radius) && 
						(e.getX() <= balls.get(i).x + balls.get(i).radius) &&
						(e.getY() >= balls.get(i).y - balls.get(i).radius) && 
						(e.getY() <= balls.get(i).y + balls.get(i).radius)    )
					balls.remove(i);
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}