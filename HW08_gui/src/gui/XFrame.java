package gui;
import javax.swing.JFrame;

public class XFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public XFrame()
	{
		setTitle("Калькулятор");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 300, 350);
		add(new XPanel());
		//add(new XPanel1());
		setVisible(true);
		setResizable(false);
		
		
		
		/*setTitle("MicroPaint");
		setBounds(0, 0, 1000, 800);
		add(new XPaint());
		setVisible(true);
		setResizable(false);*/
	}
}
