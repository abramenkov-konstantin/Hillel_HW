package thread;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class XPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public XPanel() 
	{
		setLayout(null);
		Thread tm = new Thread(new TAction());
		tm.start();
		addMouseListener(this);
	}

	class TAction implements Runnable
	{
		public void actionPerformed() 
		{
			for (Component c : getComponents())
			{
				XBall b = (XBall)c;
				b.move();
			}
		}

		@Override
		public void run() 
		{
			try 
			{
				while(true)
				{
					actionPerformed();
					Thread.sleep(50);
				}
			}
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		add( new XBall(e.getPoint()) );
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
