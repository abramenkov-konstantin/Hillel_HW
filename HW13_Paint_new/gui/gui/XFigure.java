package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class XFigure extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XFigure(XCommand cmd) 
	{
		setLayout(new GridLayout(5, 1));
		setBackground(Color.gray);

		JButton btnRect = new JButton("Rectangle");
		JButton btnOval = new JButton("Oval");
		JButton btnLine = new JButton("Line");
		JButton btnRRect = new JButton("RRectangle");
		JButton btnPaint = new JButton("Paint");

		add(btnRect);
		add(btnOval);
		add(btnLine);
		add(btnRRect);
		add(btnPaint);

		btnRect.addActionListener( cmd.aFigureRect );
		btnOval.addActionListener( cmd.aFigureOval );
		btnLine.addActionListener( cmd.aFigureLine );
		btnRRect.addActionListener( cmd.aFigureRRect ); 
		btnPaint.addActionListener( cmd.aFigurePaint );
		
	}
}
