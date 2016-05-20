package ballsPaintOut_1;

import javax.swing.JFrame;

public class XFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XFrame()
	{
		setTitle("My Balls App");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);
		add( new XPanel() );
		setVisible(true);
	}
}
