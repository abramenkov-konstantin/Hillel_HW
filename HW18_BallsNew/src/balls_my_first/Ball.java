package balls_my_first;

import java.awt.*;

public class Ball 
{
	float x=100, y=100;           
	float speedX, speedY;
	float radius;
	float angleInDegree;
	float speed;
	private Color color; 
	
	// Init the ball at a random location (inside the box) and moveAngle

		/** Full constructor*/
		public Ball(float x, float y) 
		{
			speed = (float) (1 + Math.random()*20);
			angleInDegree = (float) (Math.random()*360);
			Color randomColor = new Color ((int) Math.random()*255, (int) Math.random()*255, (int) Math.random()*255);
			System.out.println(randomColor);
			this.x = x;
			this.y = y;
			this.speedX = (float)(speed * Math.cos(Math.toRadians(angleInDegree)));
			this.speedY = (float)(-speed * (float)Math.sin(Math.toRadians(angleInDegree)));
			this.radius = (float) (10 + Math.random()*100);
			this.color = randomColor;
		}
		
		/** Draw itself using the given graphics context. */
		public void draw(Graphics g) 
		{
			g.setColor(color);
			g.fillOval((int)(x - radius), (int)(y - radius), (int)(2 * radius), (int)(2 * radius));
		}

		/** 
		 * Make one move, check for collision and react accordingly if collision occurs.
		 * 
		 * @param box: the container (obstacle) for this ball. 
		 */
		public void moveOneStepWithCollisionDetection(ContainerBox box) 
		{
			// Get the ball's bounds, offset by the radius of the ball
			float ballMinX = box.minX + radius;
			float ballMinY = box.minY + radius;
			float ballMaxX = box.maxX - radius;
			float ballMaxY = box.maxY - radius;

			// Calculate the ball's new position
			x += speedX;
			y += speedY;
			// Check if the ball moves over the bounds. If so, adjust the position and speed.
			if (x < ballMinX) 
			{
				speedX = -speedX; // Reflect along normal
				x = ballMinX;     // Re-position the ball at the edge
			} 
			else if (x > ballMaxX) 
			{
				speedX = -speedX;
				x = ballMaxX;
			}
			// May cross both x and y bounds
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