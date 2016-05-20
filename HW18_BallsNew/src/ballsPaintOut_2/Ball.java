package ballsPaintOut_2;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball
{
	int x;
	int y;
	int dx;
	int dy;
	int radius;
	Color col;

	public Ball(int x, int y) 
	{
		this.x = x;
		this.y = y;
		
		Random r = new Random();
		radius= 50 + r.nextInt(50);
		dx = r.nextInt(15) - 5;
		dy = r.nextInt(15) - 5;
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	
	public Ball(int x, int y, int dx, int dy, int radius) 
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.radius = radius;
		Random r = new Random();
		col = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
	}
	

	public void paint(Graphics g) 
	{
		Graphics2D gg = (Graphics2D) g;
		gg.setColor(col);
		gg.fillOval(x-radius/2, y-radius/2, radius, radius);
	}
}
