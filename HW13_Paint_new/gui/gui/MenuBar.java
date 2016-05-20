package gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar(XCommand cmd)
	{
		//===================================
		// file
		//===================================

		JMenu mnuFile = new JMenu("File");

		JMenuItem mnuNew = new JMenuItem("New");
		mnuNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		JMenuItem mnuOpen = new JMenuItem("Open");
		mnuOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		JMenuItem mnuSave = new JMenuItem("Save");
		mnuSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		JMenuItem mnuExit = new JMenuItem("Exit");
		mnuExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));

		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator();       
		mnuFile.add(mnuExit);

		mnuOpen.addActionListener( cmd.aNew );
		mnuOpen.addActionListener( cmd.aOpen );
		mnuSave.addActionListener( cmd.aSave );
		mnuExit.addActionListener( cmd.aExit );

		add(mnuFile);

		
		JMenu mnuColor = new JMenu("Color");

		JMenuItem mnuColBlack  = new JMenuItem("Black");
		JMenuItem mnuColRed    = new JMenuItem("Red");
		JMenuItem mnuColGreen  = new JMenuItem("Green");
		JMenuItem mnuColBlue   = new JMenuItem("Blue");
		JMenuItem mnuColOther  = new JMenuItem("Other");
		
		mnuColor.add(mnuColBlack);
		mnuColor.add(mnuColRed);
		mnuColor.add(mnuColGreen);
		mnuColor.add(mnuColBlue);
		mnuColor.add(new JSeparator());
		mnuColor.add(mnuColOther);

		mnuColBlack.addActionListener( cmd.aColorBlack );
		mnuColRed.addActionListener( cmd.aColorRed );
		mnuColGreen.addActionListener( cmd.aColorGreen );
		mnuColBlue.addActionListener( cmd.aColorBlue );
		mnuColOther.addActionListener( cmd.aColor );
		
		add(mnuColor);


		JMenu mnuWidth = new JMenu("Width");

		JMenuItem mnuW1     = new JMenuItem("1");
		JMenuItem mnuW3     = new JMenuItem("3");
		JMenuItem mnuW5     = new JMenuItem("5");
		JMenuItem mnuW10    = new JMenuItem("10");
		JMenuItem mnuW15    = new JMenuItem("15");
		JMenuItem mnuWOther = new JMenuItem("Other");

		mnuWidth.add(mnuW1);
		mnuWidth.add(mnuW3);
		mnuWidth.add(mnuW5);
		mnuWidth.add(mnuW10);
		mnuWidth.add(mnuW15);
		mnuWidth.add(new JSeparator());
		mnuWidth.add(mnuWOther);

		mnuW1.addActionListener( cmd.aWidth1 );
		mnuW3.addActionListener( cmd.aWidth3 );
		mnuW5.addActionListener( cmd.aWidth5 );
		mnuW10.addActionListener( cmd.aWidth10 );
		mnuW15.addActionListener( cmd.aWidth15 );
		mnuWOther.addActionListener( cmd.aWidthOther );
		add(mnuWidth);

		
		JMenu mnuFigures = new JMenu("Figures");

		JMenuItem mnuFiguresRect  = new JMenuItem("Rectangle");
		JMenuItem mnuFiguresOval  = new JMenuItem("Oval");
		JMenuItem mnuFiguresLine  = new JMenuItem("Line");
		JMenuItem mnuFiguresRRect = new JMenuItem("Round Rectangle");
		JMenuItem mnuFiguresPaint = new JMenuItem("Paint");
		
		mnuFigures.add(mnuFiguresRect);
		mnuFigures.add(mnuFiguresOval);
		mnuFigures.add(mnuFiguresLine);
		mnuFigures.add(mnuFiguresRRect);
		mnuFigures.add(new JSeparator());
		mnuFigures.add(mnuFiguresPaint);

		mnuFiguresRect.addActionListener( cmd.aFigureRect );
		mnuFiguresOval.addActionListener( cmd.aFigureOval );
		mnuFiguresLine.addActionListener( cmd.aFigureLine );
		mnuFiguresRRect.addActionListener( cmd.aFigureRRect );
		mnuFiguresPaint.addActionListener( cmd.aFigurePaint );
		
		add(mnuFigures);
		
		JMenuItem mnuAbout = new JMenuItem("About");

		mnuAbout.addActionListener( cmd.aAbout );
		add(mnuAbout);

		//============

	}
}
