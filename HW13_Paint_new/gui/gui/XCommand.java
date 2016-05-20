package gui;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class XCommand 
{
	ActionOpen  aNew   = new ActionOpen();
	ActionOpen  aOpen  = new ActionOpen();
	ActionSave  aSave  = new ActionSave();
	ActionExit  aExit  = new ActionExit();
	ActionAbout aAbout = new ActionAbout();

	ActionColor      aColor      = new ActionColor();
	ActionColorBlack aColorBlack = new ActionColorBlack();
	ActionColorRed   aColorRed   = new ActionColorRed();
	ActionColorGreen aColorGreen = new ActionColorGreen();
	ActionColorBlue  aColorBlue  = new ActionColorBlue();

	ActionWidth1  aWidth1  = new ActionWidth1();
	ActionWidth3  aWidth3  = new ActionWidth3();
	ActionWidth5  aWidth5  = new ActionWidth5();
	ActionWidth10  aWidth10  = new ActionWidth10();
	ActionWidth15  aWidth15  = new ActionWidth15();
	ActionWidthOther  aWidthOther  = new ActionWidthOther();

	ActionFigureRect  aFigureRect  = new ActionFigureRect();
	ActionFigureOval  aFigureOval  = new ActionFigureOval();
	ActionFigureLine  aFigureLine  = new ActionFigureLine();
	ActionFigureRRect aFigureRRect  = new ActionFigureRRect();
	ActionFigurePaint aFigurePaint  = new ActionFigurePaint();
	
	XData xd = new XData();
	JPanel pnl = null;

	class ActionNew implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			// TODO
			/*Graphics2D gg = (Graphics2D) xd.bi.getGraphics();
			gg.setColor( Color.white );
			gg.fillRect(0, 0, 540,480);
			
			repaint();*/
			
		}
	}
	
	class ActionOpen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			try 
			{

				JFileChooser fd = new JFileChooser();
				if( fd.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
				{
					File ff = fd.getSelectedFile();
					xd.bi = ImageIO.read(ff);
					pnl.repaint();
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	class ActionSave implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			try 
			{
				JFileChooser fd = new JFileChooser();
				if( fd.showSaveDialog(null) == JFileChooser.APPROVE_OPTION )
				{
					File ff = fd.getSelectedFile();
					ImageIO.write(xd.bi, "jpg", ff);
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	class ActionExit implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}

	class ActionColor implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.col = JColorChooser.showDialog(null, "My Line Color", xd.col);
		}
	}

	class ActionColorBlack implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.col = Color.black;
		}

	}
	class ActionColorRed implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.col = Color.red;
		}

	}
	class ActionColorGreen implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.col = Color.green;
		}

	}
	class ActionColorBlue implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.col = Color.blue;
		}
	}

	class ActionWidth1 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.width = 1;
		}
	}

	class ActionWidth3 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.width = 3;
		}
	}
	class ActionWidth5 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.width = 5;
		}
	}
	class ActionWidth10 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.width = 10;
		}
	}
	class ActionWidth15 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.width = 15;
		}
	}
	class ActionWidthOther implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String s= JOptionPane.showInputDialog("Input width");
			try
			{
				Integer.parseInt(s);
			}
			catch(NumberFormatException e)
			{
				return;
			}
			xd.width = Integer.parseInt(s);
		}
	}
	
	class ActionFigureRect implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.figure = "Rectangle";
		}
	}
	
	class ActionFigureOval implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.figure = "Oval";
		}
	}

	class ActionFigureLine implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.figure = "Line";
		}
	}
	class ActionFigureRRect implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.figure = "RRectangle";
		}
	}
	class ActionFigurePaint implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			xd.figure = "Paint";
		}
	}

	class ActionAbout implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(null, "This is MyPainter by Abr.\nAll rights reserved. \n2016");
		}
	}
}
