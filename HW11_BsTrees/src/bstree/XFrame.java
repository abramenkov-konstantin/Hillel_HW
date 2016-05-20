package bstree;

import javax.swing.JFrame;

public class XFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XFrame()
	{
	setTitle("My Tree");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setBounds(100, 100, 640, 480);

	add( new XPanel() );
	
	setVisible (true);
	}

}
