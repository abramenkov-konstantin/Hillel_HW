package timer;

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
		setBounds(200, 200, 500, 400);
		add( new XPanel() );
		setVisible(true);
	}
}
