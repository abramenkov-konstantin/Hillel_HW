package balls;

import java.awt.*;

public class Ball 
{
	float x, y;           
	float speedX, speedY;
	float radius;         
	private Color color; 
	private static final Color DEFAULT_COLOR = Color.BLUE;

	/** Full constructor*/
	public Ball(float x, float y, float radius, float speed, float angleInDegree, Color color) 
	{
		this.x = x;
		this.y = y;
		this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
		this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
		this.radius = radius;
		this.color = color;
	}

	/** Constructor with the default color , integers */
	public Ball(int x, int y, int radius, int speed, int angleInDegree) 
	{
		this(x, y, radius, speed, angleInDegree, DEFAULT_COLOR);
	}

	public void draw(Graphics g) 
	{
		g.setColor(color);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
	}

	public void moveOneStepWithCollisionDetection(ContainerBox box) 
	{
		float ballMinX = box.minX + radius;
		float ballMinY = box.minY + radius;
		float ballMaxX = box.maxX - radius;
		float ballMaxY = box.maxY - radius;

		x += speedX;
		y += speedY;
		if (x < ballMinX) 
		{
			speedX = -speedX; 
			x = ballMinX;     
		} 
		else if (x > ballMaxX) 
		{
			speedX = -speedX;
			x = ballMaxX;
		}
		if (y < ballMinY) 
		{
			speedY = -speedY;
			y = ballMinY;
		} 
		else if (y > ballMaxY) 
		{
			speedY = -speedY;
			y = ballMaxY;
		}
	}
}
