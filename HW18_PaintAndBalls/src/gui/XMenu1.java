package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
//import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class XMenu1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	XData xd = null;

	public XMenu1(XData xd) {

		this.xd = xd;

		// создаем панель меню
		JMenuBar menubar = new JMenuBar();

		// создаем меню
		JMenu file_menu = new JMenu("File");
		JMenu color_menu = new JMenu("Color");
		JMenu width_menu = new JMenu("Width");
		JMenu about_menu = new JMenu("About");

		// ------------------------------------
		// добавление простых элементов меню File
		JMenuItem itm = new JMenuItem("Open");
		itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		itm.addActionListener(this);
		file_menu.add(itm);

		itm = new JMenuItem("Save");
		itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		itm.addActionListener(this);
		file_menu.add(itm);
		// добавляем разделитель
		file_menu.add(new JSeparator());

		itm = new JMenuItem("Exit");
		itm.addActionListener(this);
		file_menu.add(itm);


		
		// создаем вложенное меню
		/*JMenu submenu = new JMenu("Sub");
   itm = new JMenuItem("Print");
   itm.addActionListener(this);
   submenu.add(itm);*/

		// следующему элементу назначим быструю
		// клавишу: ALT+E
		/*itm = new JMenuItem("Export");
   itm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
		ActionEvent.ALT_MASK));
   itm.addActionListener(this);
   submenu.add(itm);*/

		// добавляем вложенное меню
		//file_menu.add(submenu);

		// добавляем меню в панель меню
		menubar.add(file_menu);
		menubar.add(color_menu);
		menubar.add(width_menu);
		menubar.add(about_menu);

		// добавляем панель меню в окно
		setJMenuBar(menubar);



		// -------------------------------------------
		// настройка окна
		//setTitle("Menu Demo"); // заголовок окна
		// желательные размеры окна
		//setPreferredSize(new Dimension(640, 480));
		// завершить приложение при закрытии окна
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//pack(); // устанавливаем желательные размеры
		//setVisible(true); // отображаем окно
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());

	}
}