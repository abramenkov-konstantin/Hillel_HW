package command;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dal.Person;
import dal.PersonDAO;
import dal.PersonDAO_H2;
//import dal.PersonDAO_XML;
//import dal.PersonDAO_CSV;
//import dal.PersonDAO_Cassandra;
//import dal.PersonDAO_JSON;
//import dal.PersonDAO_Mongo;
//import dal.PersonDAO_MsSQL;
//import dal.PersonDAO_MySQL;
//import dal.PersonDAO_XML;
//import dal.PersonDAO_YAML;
//import dal.PersonDAO_Mongo;
//import dal.PersonDAO_MySQL;
import model.PersonTableModel;
import view.FunctionalPanel;
import view.InputPanel;
import view.XPanel;
public class XCommand 
{
	PersonTableModel ptm;
	PersonDAO pd;
	ArrayList<Person> rr;
	JTable tbl;
	JScrollPane scr;
	XPanel xPanel;
	FunctionalPanel fPanel;
	InputPanel iPanel;
	public ActionCreate aCreate = new ActionCreate();
	public ActionRead   aRead =  new ActionRead();
	public ActionUpdate aUpdate = new ActionUpdate();
	public ActionDelete aDelete = new ActionDelete();
	public ActionToXML aXML = new ActionToXML();
	public ActionToJSON aJSON = new ActionToJSON();
	public ActionToCSV aCSV = new ActionToCSV();
	public ActionToYaml aYaml = new ActionToYaml();
	public ActionFromXML afromXML = new ActionFromXML();
	public ActionFromCSV afromCSV = new ActionFromCSV();
	public ActionFromJSON afromJSON = new ActionFromJSON();
	public ActionFromYaml afromYaml = new ActionFromYaml();
	
	
	public XCommand(XPanel xp, FunctionalPanel fp/*, InputPanel iPanel*/)
	{		
		pd = new PersonDAO_H2();
		//pd = new PersonDAO_Mongo();
		//pd = new PersonDAO_MySQL();
		//pd = new PersonDAO_JSON();
		//pd = new PersonDAO_Cassandra();
		//pd = new PersonDAO_MsSQL();
		//pd = new PersonDAO_XML();
		//pd = new PersonDAO_YAML();
		//pd = new PersonDAO_CSV();
		this.xPanel = xp;
		this.fPanel = fp;
		//this.iPanel = iPanel;		
		
	}
	
	class ActionCreate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try
			{
				int id = Integer.parseInt(iPanel.idPerson.getText());
				String fname = iPanel.fnamePerson.getText();
				String lname = iPanel.lnamePerson.getText();
				int age = Integer.parseInt(iPanel.agePerson.getText());
				Person p = new Person(id,fname,lname,age);
				pd.create(p);
				
				rr.add(p);
				tbl.revalidate();
				tbl.repaint();
			}
			catch (NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null, "Something went wrong");
			}
		}
	}
	class ActionRead implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			rr = pd.read();	
			newTable();
			tbl.revalidate();
			tbl.repaint();		
		}
	}
	class ActionUpdate implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try
			{
				int id = Integer.parseInt(iPanel.idPerson.getText());
				String fname = iPanel.fnamePerson.getText();
				String lname = iPanel.lnamePerson.getText();
				int age = Integer.parseInt(iPanel.agePerson.getText());
				for (Person p : rr)
				{
					if ( id == p.id)
					{					
						p.fname = fname;
						p.lname = lname;
						p.age = age;
						pd.update(p);
						
						break;
					}
				}
				tbl.revalidate();
				tbl.repaint();
			}
			catch (NumberFormatException ne)
			{
				JOptionPane.showMessageDialog(null, "Something went wrong");
			}
		}
	}
	class ActionDelete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			int id = Integer.parseInt(iPanel.idPerson.getText());
			int i = 0;
			for (Person p : rr)
			{
				if ( id == p.id)
				{
					pd.delete(p);
					rr.remove(i);
					break;
				}
				i++;
			}
			tbl.revalidate();
			tbl.repaint();
		}
	}
	
	class ActionToXML implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			Convertor xml = new ConvertorXML();
			xml.toFormat(rr);
		}	
	}
	
	class ActionToJSON implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor json = new ConvertorJSON_Manual();
			json.toFormat(rr);	
		}		
	}
	
	class ActionToCSV implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor csv = new ConvertorCSV();
			csv.toFormat(rr);
		}		
	}
	
	class ActionToYaml implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor yaml = new ConvertorYaml();
			yaml.toFormat(rr);
		}
		
	}
	class ActionFromXML implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor xml = new ConvertorXML();
			rr = xml.fromFormat();
			newTable();
			tbl.revalidate();
			tbl.repaint();
		}		
	}
	
	class ActionFromJSON implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor json = new ConvertorJSON();
			rr = json.fromFormat();
			newTable();
			tbl.revalidate();
			tbl.repaint();
		}	
	}
	
	class ActionFromCSV implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor csv = new ConvertorCSV();
			rr = csv.fromFormat();
			newTable();
			tbl.revalidate();
			tbl.repaint();
		}	
	}
	
	class ActionFromYaml implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Convertor json = new ConvertorYaml_Manual();
			rr = json.fromFormat();
			newTable();
			tbl.revalidate();
			tbl.repaint();
			
		}
		
	}
	void newTable()
	{
		ptm = new PersonTableModel(rr);	
		tbl = new JTable(ptm);	
		scr = new JScrollPane(tbl);
		scr.setBounds(20, 20, 500, 200);
		xPanel.add(scr);
	}
}
