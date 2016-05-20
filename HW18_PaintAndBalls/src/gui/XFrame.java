package gui;

import javax.swing.JFrame;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class XFrame extends JFrame implements ActionListener 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XFrame()
	{
		setTitle("My PaintAndBalls");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 800, 600);

		XData xd = new XData();
		XGPanel gp = new XGPanel( xd );
		add( gp );
				
		
		JMenuBar menubar = new JMenuBar();
		JMenu file_menu = new JMenu("File");
		//JMenu color_menu = new JMenu("Color");
		//JMenu width_menu = new JMenu("Width");
		//JMenu about_menu = new JMenu("About");

		JMenuItem itm = new JMenuItem("Open");
		itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		itm.addActionListener(this);
		file_menu.add(itm);
		//
		itm = new JMenuItem("Save");
		itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		itm.addActionListener(this);
		file_menu.add(itm);
		// добавляем разделитель
		file_menu.add(new JSeparator());
		//
		itm = new JMenuItem("Exit");
		itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				ActionEvent.CTRL_MASK));
		itm.addActionListener(this);
		file_menu.add(itm);

		/*itm = new JMenuItem("Black");
		itm.addActionListener(this);
		color_menu.add(itm);
		itm = new JMenuItem("Red");
		itm.addActionListener(this);
		color_menu.add(itm);
		itm = new JMenuItem("Green");
		itm.addActionListener(this);
		color_menu.add(itm);
		itm = new JMenuItem("Blue");
		itm.addActionListener(this);
		color_menu.add(itm);
		color_menu.add(new JSeparator());
		itm = new JMenuItem("Other");
		itm.addActionListener(this);
		color_menu.add(itm);

		itm = new JMenuItem("1");
		itm.addActionListener(this);
		width_menu.add(itm);
		itm = new JMenuItem("3");
		itm.addActionListener(this);
		width_menu.add(itm);
		itm = new JMenuItem("5");
		itm.addActionListener(this);
		width_menu.add(itm);
		itm = new JMenuItem("10");
		itm.addActionListener(this);
		width_menu.add(itm);
		width_menu.add(new JSeparator());
		itm = new JMenuItem("Dialog");
		itm.addActionListener(this);
		width_menu.add(itm);

		itm = new JMenuItem("About program");
		itm.addActionListener(this);
		about_menu.add(itm);
		about_menu.add(new JSeparator());
		itm = new JMenuItem("Help");
		itm.addActionListener(this);
		about_menu.add(itm);*/

		// добавляем панель меню в окно
		menubar.add(file_menu);
		/*menubar.add(color_menu);
		menubar.add(width_menu);
		menubar.add(about_menu);*/

		setJMenuBar(menubar);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
		case "Open":
			break;
		case "Save":
			break;
		case "Exit": System.exit(0);
		break;
		case "Black":
			break;
		case "Red":
			break;
		case "Green":
			break;
		case "Blue":
			break;
		case "Other": 
			//xd.col = JColorChooser.showDialog(null, "My Line Color", xd.col);
			break;
		case "1": 
			//xd.width = 1;
			break;
		case "3": 

			break;
		case "5": 

			break;
		case "10": 

			break;
		case "Dialog": 

			break;
		case "About program": 
			JOptionPane.showMessageDialog(null,"Это Пейнт");
			break;
		case "Help": 
			JOptionPane.showMessageDialog(null,"Тут будет какая-то ссылка");
			break;

		default:
			System.out.println(e.getActionCommand());
		}

	}
}
