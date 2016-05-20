package gui;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class XColor extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XColor(XCommand cmd) 
	{  
		setLayout(new GridLayout(5, 1));
		setBackground(Color.white);

		JButton btnBlack = new JButton("Black");
		JButton btnRed = new JButton("Red");
		JButton btnGreen = new JButton("Green");
		JButton btnBlue = new JButton("Blue");
		JButton btnOther = new JButton("Other");

		add(btnBlack);
		add(btnRed);
		add(btnGreen);
		add(btnBlue);
		add(btnOther);

		btnBlack.addActionListener( cmd.aColorBlack );
		btnRed.addActionListener( cmd.aColorRed );
		btnGreen.addActionListener( cmd.aColorGreen );
		btnBlue.addActionListener( cmd.aColorBlue ); 
		btnOther.addActionListener( cmd.aColor );
	}
}
