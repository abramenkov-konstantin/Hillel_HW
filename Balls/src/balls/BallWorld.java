package balls;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class BallWorld extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private static final int UPDATE_RATE = 30;  
	private Ball ball;        
	private ContainerBox box;  
	private DrawCanvas canvas; 
	private int canvasWidth;
	private int canvasHeight;
	private int xfirst;
	private int yfirst;

	public BallWorld(int width, int height) 
	{
		canvasWidth = width;
		canvasHeight = height;

		Random rand = new Random();
		int radius = 10 + rand.nextInt(100);
		int x = rand.nextInt(canvasWidth - radius * 2 - 20) + radius + 10;
		int y = rand.nextInt(canvasHeight - radius * 2 - 20) + radius + 10;
		Color randomColor = new Color (rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)); 
		int speed = 1 + rand.nextInt(15);
		int angleInDegree = rand.nextInt(360);
		ball = new Ball(x, y, radius, speed, angleInDegree, randomColor);

		MouseListener mouseListener = new MouseListener() 
		{
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.out.println("aqwdqwidjqwioehwieuf");
				xfirst = e.getX();
				yfirst = e.getY();
				Random rand = new Random();
				int radius = 10 + rand.nextInt(100);
				Color randomColor = new Color (rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)); 
				int speed = 1 + rand.nextInt(35);
				int angleInDegree = rand.nextInt(360);
				ball = new Ball(xfirst, yfirst, radius, speed, angleInDegree, randomColor);
			}
		};
		this.addMouseListener(mouseListener);

		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.WHITE, Color.BLUE);
		canvas = new DrawCanvas();
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
		/*this.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentResized(ComponentEvent e) 
			{
				Component c = (Component)e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;
				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});*/
		gameStart();
	}

	public void gameStart() 
	{
		Thread gameThread = new Thread() 
		{
			public void run() 
			{
				while (true) 
				{
					gameUpdate();
					repaint();
					try {
						Thread.sleep(1000 / UPDATE_RATE);
					} catch (InterruptedException ex) {}
				}
			}
		};
		gameThread.start();  
	}

	public void gameUpdate() 
	{
		ball.moveOneStepWithCollisionDetection(box);
	}

	class DrawCanvas extends JPanel 
	{
		private static final long serialVersionUID = 1L;

		@Override
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);   
			box.draw(g);
			ball.draw(g);
		}

		/*@Override
		public Dimension getPreferredSize() 
		{
			return (new Dimension(canvasWidth, canvasHeight));
		}*/
	}
}
