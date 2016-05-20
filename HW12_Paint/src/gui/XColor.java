package gui;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class XColor extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	XData xd = null;

	public XColor(XData xd) 
	{  
		this.xd = xd;
		
		setLayout(new GridLayout(7, 1));
		setBackground(xd.col);

		JButton btn1 = new JButton("Black");
		//btn1.setBounds(10, 20, 120, 20);
		add(btn1);
		JButton btn2 = new JButton("Red");
		//btn2.setBounds(10, 20, 120, 20);
		add(btn2);
		JButton btn3 = new JButton("Green");
		//btn3.setBounds(10, 20, 120, 20);
		add(btn3);
		JButton btn4 = new JButton("Blue");
		//btn4.setBounds(10, 20, 120, 20);
		add(btn4);
		JButton btn5 = new JButton("Other");
		//btn5.setBounds(10, 20, 120, 20);
		add(btn5);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.col = Color.BLACK;
				setBackground(Color.BLACK);
			}
		});
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.col = Color.RED;
				setBackground(Color.RED);
			}
		});
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.col = Color.GREEN;
				setBackground(Color.GREEN);
			}
		});
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.col = Color.BLUE;
				setBackground(Color.BLUE);
			}
		});
		btn5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.col = JColorChooser.showDialog(null, "My Line Color", xd.col);
				setBackground(xd.col);
			}
		});
	}
}
