package gui;

import javax.swing.JPanel;

/*import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;*/

public class XGPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XGPanel(XData xd) 
	{
		setLayout(null);
		
		XWidth wp = new XWidth( xd );
		XColor cp = new XColor( xd );
		XPanel xp = new XPanel( xd );
		XMenu1 xm = new XMenu1 ( xd );
						
		xm.setBounds(0, 0, 20, 640);
		cp.setBounds(0, 0, 150, 220);
		wp.setBounds(0, 220, 150, 220);
		xp.setBounds(150, 0, 490, 460);
		
		/*frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);*/
		
		add(wp);
		add(cp);
		add(xp);
		
	}
}
