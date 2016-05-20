package balls_my_first;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * The control logic and main display panel for game.
 */
public class BallWorld extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private static final int UPDATE_RATE = 30;  // Frames per second (fps)
	private Ball ball;         // A single bouncing Ball's instance
	private ContainerBox box;  // The container rectangular box
	private DrawCanvas canvas; // Custom canvas for drawing the box/ball
	private int canvasWidth;
	private int canvasHeight;
	private int xfirst;
	private int yfirst;

	/**
	 * Constructor to create the UI components and init the game objects.
	 * Set the drawing canvas to fill the screen (given its width and height).
	 * 
	 * @param width : screen width
	 * @param height : screen height
	 */
	public BallWorld(int width, int height) 
	{
		canvasWidth = width;
		canvasHeight = height;
		
		ball = new Ball(100, 100);
	
		
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
				System.out.println("new ball created");
				xfirst = e.getX();
				yfirst = e.getY();
				ball = new Ball(xfirst, yfirst);
				
			}
		};
		this.addMouseListener(mouseListener);
				
		// Init the Container Box to fill the screen
		box = new ContainerBox(0, 0, canvasWidth, canvasHeight, Color.WHITE, Color.BLUE);

		// Init the custom drawing panel for drawing the game
		canvas = new DrawCanvas();
		this.setLayout(new BorderLayout());
		this.add(canvas, BorderLayout.CENTER);
			
		// Handling window resize.
		this.addComponentListener(new ComponentAdapter() 
		{
			@Override
			public void componentResized(ComponentEvent e) 
			{
				Component c = (Component)e.getSource();
				Dimension dim = c.getSize();
				canvasWidth = dim.width;
				canvasHeight = dim.height;
				// Adjust the bounds of the container to fill the window
				box.set(0, 0, canvasWidth, canvasHeight);
			}
		});
		// Start the ball bouncing
		gameStart();
	}

	/** Start the ball bouncing. */
	public void gameStart() 
	{
		// Run the game logic in its own thread.
		Thread gameThread = new Thread() 
		{
			public void run() 
			{
				while (true) 
				{
					// Execute one time-step for the game 
					gameUpdate();
					repaint();
					// Delay and give other thread a chance
					try {
						Thread.sleep(1000 / UPDATE_RATE);
					} catch (InterruptedException ex) {}
				}
			}
		};
		gameThread.start();  // Invoke GameThread.run()
	}

	/** 
	 * One game time-step. 
	 * Update the game objects, with proper collision detection and response.
	 */
	public void gameUpdate() 
	{
		ball.moveOneStepWithCollisionDetection(box);
	}

	/** The custom drawing panel for the bouncing ball (inner class). */
	class DrawCanvas extends JPanel 
	{
		private static final long serialVersionUID = 1L;

		/** Custom drawing codes */
		@Override
		public void paintComponent(Graphics g) 
		{
			super.paintComponent(g);    // Paint background
			// Draw the box and the ball
			box.draw(g);
			ball.draw(g);
		}

		/** Called back to get the preferred size of the component. */
		@Override
		public Dimension getPreferredSize() 
		{
			return (new Dimension(canvasWidth, canvasHeight));
		}
	}
}
