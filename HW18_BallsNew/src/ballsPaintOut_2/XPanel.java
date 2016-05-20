package ballsPaintOut_2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;


public class XPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	
	
	// checking of 1-st commit
	private static final long serialVersionUID = 1L;
	ArrayList<Ball> balls = new ArrayList<>();

	public XPanel() 
	{
		setLayout(null);
		addMouseListener(this);

		Thread tm = new Thread(new TAction());
		tm.start();
	}

	class TAction implements Runnable
	{
		@Override
		public void run() 
		{
			try 
			{
				while(true)
				{
					repaint();
					Thread.sleep(50);
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

		for (int i =0; i< balls.size(); i++)
		{
			//отражение от стенок
			if(balls.get(i).x <= balls.get(i).radius/2 || balls.get(i).x+balls.get(i).radius/2 >= dd.getWidth())
				balls.get(i).dx = -balls.get(i).dx;
			if(balls.get(i).y <= balls.get(i).radius/2 || balls.get(i).y+balls.get(i).radius/2 >= dd.getHeight())
			balls.get(i).dy = -balls.get(i).dy;
			balls.get(i).x+=balls.get(i).dx;
			balls.get(i).y+=balls.get(i).dy;
			balls.get(i).paint(gg);

			for (int j=i; j < balls.size(); j++)
			{
				double k=0.8;
				if (i!=j && 												     //--не сравниваем с собой--
			       (balls.get(j).x >= balls.get(i).x - balls.get(i).radius*k) && //--ищем пересечение------- 
				   (balls.get(j).x <= balls.get(i).x + balls.get(i).radius*k) && //
			       (balls.get(j).y >= balls.get(i).y - balls.get(i).radius*k) && //
			       (balls.get(j).y <= balls.get(i).y + balls.get(i).radius*k) && //-------------------------
			       
			       //чтобы не вылазили за границы
			       (balls.get(i).x >= balls.get(i).radius*0.5+balls.get(j).radius*0.5 || 
			        balls.get(i).x+balls.get(i).radius*0.5+balls.get(j).radius*0.5 <= dd.getWidth()) &&
			       (balls.get(i).y >= balls.get(i).radius*0.5+balls.get(j).radius*0.5 || 
			       balls.get(i).y+balls.get(i).radius*0.5+ balls.get(j).radius*0.5 <= dd.getHeight()
			       
			       
			       //(balls.get(j).x >= balls.get(j).radius*0.75 || balls.get(j).x+balls.get(j).radius*0.75 <= dd.getWidth()) &&
			       //(balls.get(j).y >= balls.get(j).radius*0.75 || balls.get(j).y+balls.get(j).radius*0.75 <= dd.getHeight()) )
						))
					{

					balls.get(i).radius = balls.get(i).radius + balls.get(j).radius/3;
					balls.remove(j);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		if (e.getModifiers()== InputEvent.BUTTON1_MASK)
		{
			balls.add (new Ball(e.getX(), e.getY()) );
		}
		else if
		(e.getModifiers()==InputEvent.BUTTON3_MASK)
		{
			for (Ball b : balls)
			{
				if ( (e.getX() >= b.x - b.radius/2) && (e.getX() <= b.x + b.radius/2) &&
					 (e.getY() >= b.y - b.radius/2) && (e.getY() <= b.y + b.radius/2) )
				{
					//explosion
					int curX = e.getX();
					int curY = e.getY();
					int curDX = b.dx;
					int curDY = b.dy;
					int curRadius = b.radius/3;
					int dDX = 5;
					int dDY = 5;

					balls.remove(b);

					balls.add (new Ball( curX-curRadius-1, curY            , -curDX-dDX, -curDY     , curRadius) ); //1
					balls.add (new Ball( curX-curRadius-1, curY-curRadius-1, -curDX-dDX, -curDY-dDY , curRadius) ); //2
					balls.add (new Ball( curX            , curY-curRadius-1,  curDX    , -curDY-dDY , curRadius) ); //3
					balls.add (new Ball( curX+curRadius+1, curY-curRadius-1,  curDX+dDX, -curDY-dDY , curRadius) ); //4
					balls.add (new Ball( curX+curRadius+1, curY            ,  curDX+dDX,  curDY     , curRadius) ); //5
					balls.add (new Ball( curX+curRadius+1, curY+curRadius+1,  curDX+dDX,  curDY+dDY , curRadius) ); //6
					balls.add (new Ball( curX            , curY+curRadius+1,  curDX    ,  curDY+dDY , curRadius) ); //7
					balls.add (new Ball( curX-curRadius-1, curY+curRadius+1, -curDX-dDX,  curDY+dDY , curRadius) ); //8
				}
			}
			repaint();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
