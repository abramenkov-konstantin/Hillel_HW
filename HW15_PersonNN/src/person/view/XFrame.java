package person.view;

import java.sql.SQLException;

import javax.swing.JFrame;

public class XFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public XFrame() throws SQLException
	{
	setTitle("My DB App");
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setBounds(100, 100, 600, 600);

	add( new XPanel() );
	
	setVisible (true);
	}

}
