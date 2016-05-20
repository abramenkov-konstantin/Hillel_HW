package gui;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class XPanel extends JPanel implements MouseMotionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	XData xd = null;
	
	int x = 0;
	int y = 0;
	
	public XPanel(XData xd) 
	{
		setLayout(null);
		
		this.xd = xd;
		
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		x = e.getX();
		y = e.getY();
	}
	
	@Override
	public void mouseDragged(MouseEvent e)
	{
		//if(e.getButton() == 1)
		{
			Graphics2D gg = (Graphics2D) getGraphics();
			gg.setColor( xd.col );
			gg.setStroke( new BasicStroke(xd.width) );
			gg.drawLine(x, y, e.getX(), e.getY());
			x = e.getX();
			y = e.getY();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == 3)
		{
			JOptionPane.showMessageDialog(null,"Это заготовка под правую кнопку");
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
