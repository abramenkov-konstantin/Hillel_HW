package person.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import person.dal.Person;
import person.model.PersonTableModel;


public class XPanel extends JPanel 
{
	protected JLabel l_id;
	protected JLabel l_fname;
	protected JLabel l_lname;
	protected JLabel l_age;

	protected JTextField text_id;
	protected JTextField text_fname;
	protected JTextField text_lname;
	protected JTextField text_age;

	protected JButton btn_create;
	protected JButton btn_read;
	protected JButton btn_update;
	protected JButton btn_delete;
	protected JButton btn_toXML;
	protected JButton btn_toJSON;
	protected JButton btn_toCSV;
	protected JButton btn_fromXML;
	protected JButton btn_fromJSON;
	protected JButton btn_fromCSV;
	
	PersonTableModel ptm;
	JTable tbl;
	JScrollPane scr;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public XPanel() throws SQLException
	{
		setLayout(new GridLayout(2, 1));

		ptm = new PersonTableModel();
		tbl = new JTable(ptm);
		scr = new JScrollPane (tbl);
		scr.setBounds(0, 0, 450, 400);
		add(scr);

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1));

		JPanel jp_t = new JPanel();
		jp_t.setLayout(new GridLayout(2, 4));
		l_id = new JLabel("ID");
		l_fname = new JLabel("FName");
		l_lname = new JLabel("LName");
		l_age = new JLabel("Age");
		text_id = new JTextField();
		text_fname = new JTextField();
		text_lname = new JTextField();
		text_age = new JTextField();
		jp_t.add(l_id);
		//jp_t.add(l_fname);
		//jp_t.add(l_lname);
		jp_t.add(l_age);
		jp_t.add(text_id);
		jp_t.add(text_fname);
		jp_t.add(text_lname);
		jp_t.add(text_age);		 

		JPanel jp_b = new JPanel();
		jp_b.setLayout(new GridLayout(2, 5));
		btn_create = new JButton("Create");
		btn_create.addActionListener(new Create());
		btn_read = new JButton("Read");
		btn_read.addActionListener(new Read());
		btn_update = new JButton("Update");
		btn_update.addActionListener(new Update());
		btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new Delete());
		btn_toXML = new JButton("toXML");
		btn_toXML.addActionListener(new ToXML());
		btn_toJSON = new JButton("toJSON");
		btn_toJSON.addActionListener(new ToJSON());
		btn_toCSV = new JButton("toCSV");
		btn_toCSV.addActionListener(new ToCSV());
		btn_fromXML = new JButton("FromXML");
		btn_fromXML.addActionListener(new FromXML());
		btn_fromJSON = new JButton("FromJSON");
		btn_fromJSON.addActionListener(new FromJSON());
		btn_fromCSV = new JButton("FromCSV");
		btn_fromCSV.addActionListener(new FromCSV());
		
		jp.add(jp_b);
		jp_b.add(btn_create);
		jp_b.add(btn_read);
		jp_b.add(btn_update);
		jp_b.add(btn_delete);
		jp_b.add(btn_toXML);
		jp_b.add(btn_fromXML);
		jp_b.add(btn_toJSON);
		jp_b.add(btn_fromJSON);
		jp_b.add(btn_toCSV);
		jp_b.add(btn_fromCSV);

		jp.add(jp_t);
		jp.add(jp_b);

		add(jp);
	}

	public class Create implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id1 = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());

			Person pp = new Person(id1, fname1, lname1, age1);
			ptm.pd.create(pp);
		}
	}
	public class Read implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			ptm.pd.read();
			ptm.rr = ptm.pd.read();
			tbl.repaint();
		}
	}
	public class Update implements ActionListener
	{
		protected int idToUpdate;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{

			int idToUpdate = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());

			Person pNew = new Person(idToUpdate, fname1, lname1, age1);
			ptm.pd.update(pNew);
		}
	}
	public class Delete implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);
		}
	}
	
	public class ToXML implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	public class ToJSON implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	public class ToCSV implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	public class FromXML implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	public class FromJSON implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	public class FromCSV implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			/*int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			ptm.pd.delete(pToDel);*/
		}
	}
	
	
}
