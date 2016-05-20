package ballsPaintOut_1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball
{
	double x;
	double y;
	double dx;
	double dy;
	double radius;
	boolean speedChanged=false; 
	Color col;

	public Ball(double x, double y) 
	{
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		radius= 50 + r.nextInt(50);
		dx = r.nextInt(15) - 5;
		dy = r.nextInt(15) - 5;
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public Ball(double x, double y, int maxRadius) 
	{
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		radius= 50 + r.nextInt(50);
		dx = r.nextInt(20) - 5;
		dy = r.nextInt(20) - 5;
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		
		if (radius > maxRadius) 
		{
		radius = maxRadius - 1 - (Math.max(Math.abs(dx), Math.abs(dy)));
		}
	}
	
	public Ball(double x, double y, double dx, double dy, int maxRadius)
	{
	this.x = x;
	this.y = y;
	this.dx = dx;
	this.dy = dy;
	this.radius = maxRadius;
	col =  Color.BLACK;
	}
	
	public void paint(Graphics g) 
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(col);
		gg.fillOval((int) (x-radius), (int) (y-radius), (int)radius*2, (int)radius*2);
		gg.setColor(Color.RED);
		gg.fillOval((int)x-3, (int)y-3, 3, 3);
	}
	
	
}
