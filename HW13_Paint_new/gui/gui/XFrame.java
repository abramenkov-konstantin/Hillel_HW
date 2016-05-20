package gui;

import javax.swing.JFrame;


public class XFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XFrame()
	{
		setTitle("My First App");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 640, 480);
		
		XCommand cmd = new XCommand();
		setJMenuBar( new MenuBar(cmd) );
		XGPanel gp = new XGPanel( cmd );
		add( gp );
		setVisible(true);
	}
}
