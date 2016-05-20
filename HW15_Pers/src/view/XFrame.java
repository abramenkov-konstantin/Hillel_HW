package view;
import javax.swing.JFrame;

public class XFrame extends JFrame 
{
	private static final long serialVersionUID = 5877895382090650764L;

	public XFrame()
	{
		setTitle("My DB App");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 80, 500, 600);
		add( new XPanel() );
		setVisible(true);
	}
}
