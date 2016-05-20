package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class XPaint extends JPanel implements MouseMotionListener, MouseListener
{
	private static final long serialVersionUID = 1L;
	protected int lastX, lastY, w=1000, h=800;
	Color currColor=Color.black;
	float basicThikness=1.0f;
	JTextField txt = null;

	public XPaint() 
	{
		JPanel areaControl = new JPanel();
		areaControl.setLayout(new GridLayout(20, 1));
		areaControl.setBounds(0, 0, w/5, h);
		add(areaControl);

		txt = new JTextField();
		setLayout(null);
		areaControl.add(txt);

		JPanel areaColor = new JPanel();
		areaColor.setBackground(currColor);
		areaControl.add(areaColor);
		areaColor.add(new JLabel("Color"));

		JButton btncolor = new JButton("Color");
		areaControl.add(btncolor);
		btncolor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currColor = JColorChooser.showDialog(null, "Some", Color.green);
				areaColor.setBackground(currColor);
			}
		});

		JPanel areaThickness = new JPanel();
		areaControl.add(areaThickness);
		areaThickness.add(new JLabel("Thickness "));
		String[] items = {"1","2","3","4","5","10","15","20","25"};
		JComboBox comboBox = new JComboBox(items);
		//editComboBox.setEditable(true);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//String item = (String)comboBox.getSelectedItem();
				basicThikness = Float.parseFloat((String)comboBox.getSelectedItem());

			}
		};
		comboBox.addActionListener(actionListener);
		areaThickness.add(comboBox);	

		JButton btnClear = new JButton("Clear");
		areaControl.add(btnClear);

		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currColor = Color.black;
				areaColor.setBackground(currColor);
				repaint();
			}
		});

		//работа с файлами
		/*File[] roots =  File.listRoots();
		JList list = new JList(roots);
		File root = (File) list.getSelectedValue();
		File[] children = root.listFiles();*/
		
		//File file = new File("C:/test.txt");
		 
		//Если требуемого файла не существует.
		//if(!file.exists()) {
		   //Создаем его.
		  // file.createNewFile();
		//}
		
		
		
		
		JPanel areaDraw = new JPanel();
		areaDraw.setBackground(Color.white);
		areaDraw.setBounds(w/5, 0, 800, 800);
		add(areaDraw);

		addMouseMotionListener(this);
		addMouseListener(this);

	}
	@Override
	public void mouseMoved(MouseEvent e) {	
		txt.setText("Move x=" + e.getX() + ", y=" + e.getY());
	}
	@Override
	public void mousePressed(MouseEvent e) {
		lastX = e.getX(); lastY = e.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		//if ((e.getModifiers() & MouseEvent.BUTTON1_MASK) ==0) return;
		Graphics g=getGraphics();
		Graphics2D gr = (Graphics2D)g;
		g.setColor(currColor);
		gr.setStroke(new BasicStroke(basicThikness));
		g.drawLine(lastX, lastY, e.getX(), e.getY());
		lastX=e.getX();
		lastY=e.getY();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		txt.setText("Move x=" + e.getX() + ", y=" + e.getY() + ".num="+ e.getButton());
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
}
