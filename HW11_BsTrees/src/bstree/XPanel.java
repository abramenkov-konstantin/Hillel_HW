package bstree;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class XPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XPanel()
	{
		setLayout(null);

		JButton btn = new JButton("Tree");
		btn.setBounds(10,10,120,20);
		add(btn);
		btn.addActionListener (new ActionListener() {

			@Override
			public void actionPerformed (ActionEvent e)	{
				int[] ar = {8,3,10,1,6,14,4,7,13,2,9};
				BsTree tree = new BsTree (ar);
				tree.show (XPanel.this.getGraphics(), getWidth() );
			}
		});
	}
}
