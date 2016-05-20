package gui;



import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

class PMenu extends JPopupMenu
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PMenu(XCommand cmd)
	{       
		JMenuItem mnuW3  = new JMenuItem("3");
		JMenuItem mnuW5  = new JMenuItem("5");
		JMenuItem mnuW10 = new JMenuItem("10");

		JMenuItem mnuCRed   = new JMenuItem("Red");
		JMenuItem mnuCBlue  = new JMenuItem("Blue");
		JMenuItem mnuCGreen = new JMenuItem("Green");
		
		JMenuItem mnuFRect   = new JMenuItem("Rectangle");
		JMenuItem mnuFOval  = new JMenuItem("Oval");
		JMenuItem mnuFLine = new JMenuItem("Line");

		add(mnuW3);
		add(mnuW5);
		add(mnuW10);

		addSeparator();

		add(mnuCRed);
		add(mnuCBlue);
		add(mnuCGreen);
		
		addSeparator();

		add(mnuFRect);
		add(mnuFOval);
		add(mnuFLine);
		
		
		mnuCRed.addActionListener( cmd.aColorRed );
		mnuCGreen.addActionListener( cmd.aColorGreen );
		mnuCBlue.addActionListener( cmd.aColorBlue );
		mnuW3.addActionListener( cmd.aWidth3 );
		mnuW5.addActionListener( cmd.aWidth5 );
		mnuW10.addActionListener( cmd.aWidth10 );
		mnuFRect.addActionListener( cmd.aFigureRect );
		mnuFOval.addActionListener( cmd.aFigureOval );
		mnuFLine.addActionListener( cmd.aFigureLine );
		
	}
}
