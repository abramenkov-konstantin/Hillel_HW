package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class XPanel extends JPanel implements MouseMotionListener, MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	XCommand cmd = null;
	int x = 0;
	int y = 0;

	public XPanel(XCommand cmd) 
	{
		setLayout(null);

		this.cmd = cmd;
		cmd.pnl = this;

		setComponentPopupMenu(new PMenu(cmd));
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
		if(cmd.xd.figure == "Paint")
		{
			Graphics2D gg = (Graphics2D) cmd.xd.bi.getGraphics();
			gg.setColor( cmd.xd.col );
			gg.setStroke( new BasicStroke(cmd.xd.width) );
			gg.drawLine(x, y, e.getX(), e.getY());
			x = e.getX();
			y = e.getY();
			repaint();
		}



	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		//Graphics2D gg = (Graphics2D) g;
		g.drawImage(cmd.xd.bi, 0, 0, null);
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(cmd.xd.figure == "Rectangle")
		{
			Graphics2D gg = (Graphics2D) cmd.xd.bi.getGraphics();
			gg.setColor( cmd.xd.col );
			gg.setStroke( new BasicStroke(cmd.xd.width) );
			//x = e.getX();
			//y = e.getY();
			gg.drawRect(x, y, e.getX()-x, e.getY()-y);
			repaint();
		}
		if(cmd.xd.figure == "Oval")
		{
			Graphics2D gg = (Graphics2D) cmd.xd.bi.getGraphics();
			gg.setColor( cmd.xd.col );
			gg.setStroke( new BasicStroke(cmd.xd.width) );
			//x = e.getX();
			//y = e.getY();
			gg.drawOval(x, y, e.getX()-x, e.getY()-y);
			repaint();
		}
		if(cmd.xd.figure == "Line")
		{
			Graphics2D gg = (Graphics2D) cmd.xd.bi.getGraphics();
			gg.setColor( cmd.xd.col );
			gg.setStroke( new BasicStroke(cmd.xd.width) );
			//x = e.getX();
			//y = e.getY();
			gg.drawLine(x, y, e.getX(), e.getY());
			repaint();
		}
		if(cmd.xd.figure == "RRectangle")
		{
			Graphics2D gg = (Graphics2D) cmd.xd.bi.getGraphics();
			gg.setColor( cmd.xd.col );
			gg.setStroke( new BasicStroke(cmd.xd.width) );
			//x = e.getX();
			//y = e.getY();
			gg.drawRoundRect(x, y, e.getX()-x, e.getY()-y, 5, 5);
			
			repaint();
		}
	}
}
