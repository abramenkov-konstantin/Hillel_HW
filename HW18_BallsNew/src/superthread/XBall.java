package superthread;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;

import javax.swing.JPanel;

public class XBall extends JPanel implements Runnable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int dx;
	int dy;
	Color col;
	
	public XBall(Point p) 
	{
		setLocation(p);
		setSize(30, 30);
		Random r = new Random();
		dx = r.nextInt(30) - 15;
		dy = r.nextInt(30) - 15;
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
		Thread tm = new Thread((Runnable) this);
		tm.start();
	}

	public void run() 
	{
		try 
		{
			while(true)
			{
				move();
				Thread.sleep(50);
			}
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) 
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(col);
		gg.fillOval(1, 1, 28, 28);
	}
	
	public void move() 
	{
		Point p = getLocation();
		if(p.getX() <= 0 || p.getX()+30 >= getParent().getWidth())
			dx = -dx;
		if(p.getY() <= 0 || p.getY()+30 >= getParent().getHeight())
			dy = -dy;
		
		p.translate(dx, dy);
		setLocation(p);
	}
}
