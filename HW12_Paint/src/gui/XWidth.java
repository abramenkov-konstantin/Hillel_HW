package gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class XWidth extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	XData xd = null;

	public XWidth(XData xd) 
	{
		this.xd = xd;
		setBackground(Color.GRAY);

		add(new JLabel("Width: "));
		String[] items = {"1","2","3","4","5","10","15","20","25"};
		JComboBox comboBox = new JComboBox(items);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xd.width = Integer.parseInt((String)comboBox.getSelectedItem());
			}
		};
		comboBox.addActionListener(actionListener);
		add(comboBox);

		/*JButton btn = new JButton("Width");
		btn.setBounds(10, 20, 120, 20);
		add(btn);

		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				xd.width = 5;
			}
		});*/
	}
}
