package timer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class XPanel extends JPanel implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public XPanel() 
	{
		setLayout(null);
		Timer tm = new Timer(50, new TAction());
		tm.start();
		
		addMouseListener(this);
	}

	class TAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			for (Component c : getComponents())
			{
				XBall b = (XBall)c;
				b.move();
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
