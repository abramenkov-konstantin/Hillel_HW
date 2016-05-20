package gui;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class XPanel1 extends JPanel 
{
	private static final long serialVersionUID = 1L;

	public XPanel1() 
	{
		setLayout(new GridLayout(4, 2, 10, 10));
				
		JButton btn1 = new JButton("showMessageDialog");
		add(btn1);
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Eggs are not supposed to be green.");
			}
		});
		
		JButton btn2 = new JButton("showInputDialog");
		add(btn2);
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Something");
			}
		});
		
		JButton btn3 = new JButton("showConfirmDialog");
		add(btn3);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "dfdfd");
			}
		});
		
		JButton btn4 = new JButton("showSaveDialog");
		add(btn4);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal1 = fc.showSaveDialog(getComponent(1));
			}
		});
		
		JButton btn5 = new JButton("showOpenDialog");
		add(btn5);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JFileChooser fc = new JFileChooser();
				int returnVal2 = fc.showOpenDialog(getComponentPopupMenu());
			}
		});
		
		JButton btn6 = new JButton("color showDialog");
		add(btn6);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				final JColorChooser cc = new JColorChooser();
				Color returnVal3 = cc.showDialog(null, "Some", Color.red);
			}
		});
		JButton btn7 = new JButton("getPrinterJob");
		add(btn7);
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.printDialog();
			}
		});
		JButton btn8 = new JButton("createFont");
		add(btn8);
		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try
				{
					Font font = Font.createFont(Font.TRUETYPE_FONT, new File("A.ttf"));
				} catch (FontFormatException | IOException e1)
				{
					//TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}