package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import command.XCommand;
import model.PersonTableModel;

public class FunctionalPanel extends JPanel
{
	private static final long serialVersionUID = 2439574626892309049L;
	
	JTextField idPerson;
	JTextField fnamePerson;
	JTextField lnamePerson;
	JTextField agePerson;
	PersonTableModel ptm;
	JTable tbl;
	
	FunctionalPanel(XPanel xp)
	{		
		XCommand cmd = new XCommand(xp,this);
		setLayout(null);
		setBounds(20,250,500,350);
	
		JButton create = new JButton("Create");
		create.setBounds(0, 0,80,30);
		add(create);

		JButton read = new JButton("Read");
		read.setBounds(90, 0,80,30);
		add(read);

		JButton update = new JButton("Update");
		update.setBounds(180, 0, 80, 30);
		add(update);

		JButton delete = new JButton("Delete");
		delete.setBounds(270, 0, 80,30);
		add(delete);

		JLabel lbl1 = new JLabel("ID");
		lbl1.setBounds(0,40,80,30);
		add(lbl1);

		JLabel lbl2 = new JLabel("First Name");
		lbl2.setBounds(0, 80, 80, 30);
		add(lbl2);

		JLabel lbl3 = new JLabel("Last Name");
		lbl3.setBounds(0, 120, 80, 30);
		add(lbl3);

		JLabel lbl4 = new JLabel("Age");
		lbl4.setBounds(0, 160, 80, 30);
		add(lbl4);

		idPerson = new JTextField();
		idPerson.setHorizontalAlignment(JTextField.CENTER);
		idPerson.setBounds(90, 40, 200, 30);
		add(idPerson);

		fnamePerson = new JTextField();
		fnamePerson.setHorizontalAlignment(JTextField.CENTER);
		fnamePerson.setBounds(90, 80, 200, 30);
		add(fnamePerson);

		lnamePerson = new JTextField();
		lnamePerson.setHorizontalAlignment(JTextField.CENTER);
		lnamePerson.setBounds(90, 120, 200, 30);
		add(lnamePerson);

		agePerson = new JTextField();
		agePerson.setHorizontalAlignment(JTextField.CENTER);
		agePerson.setBounds(90, 160, 200, 30);
		add(agePerson);
		
		JButton toXml = new JButton("toXML");
		toXml.setBounds(0,200,100,30);
		add(toXml);
		
		JButton toJson = new JButton("toJSON");
		toJson.setBounds(110, 200, 100, 30);
		add(toJson);
		
		JButton toCsv = new JButton("toCSV");
		toCsv.setBounds(220, 200, 100, 30);
		add(toCsv);
		
		JButton fromXml = new JButton("fromXML");
		fromXml.setBounds(0, 240, 100, 30);
		add(fromXml);
		
		JButton fromJson = new JButton("fromJSON");
		fromJson.setBounds(110, 240, 100, 30);
		add(fromJson);
		
		JButton fromCsv = new JButton("fromCSV");
		fromCsv.setBounds(220, 240, 100, 30);
		add(fromCsv);
		
		
		create.addActionListener(cmd.aCreate);
		update.addActionListener(cmd.aUpdate);
		read.addActionListener(cmd.aRead);
		delete.addActionListener(cmd.aDelete);
		toXml.addActionListener(cmd.aXML);
		toJson.addActionListener(cmd.aJSON);
		toCsv.addActionListener(cmd.aCSV);
		fromJson.addActionListener(cmd.afromJSON);
		fromCsv.addActionListener(cmd.afromCSV);
		fromXml.addActionListener(cmd.afromXML);
		
	}
	public String getId()
	{
		return idPerson.getText();
	}
	public String getFName()
	{
		return fnamePerson.getText();
	}
	public String getLName()
	{
		return lnamePerson.getText();
	}
	public String getAge()
	{
		return agePerson.getText();
	}
}
