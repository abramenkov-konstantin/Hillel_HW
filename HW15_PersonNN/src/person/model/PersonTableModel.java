package person.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import person.dal.*;

public class PersonTableModel extends AbstractTableModel 
{

	private static final long serialVersionUID = 1L;

	public ArrayList<Person> rr = new ArrayList<Person>();
	//public PersonDAO pd = null;

	//public PersonDAO pd = new PersonDAO_Mock();
	//public PersonDAO pd = new PersonDAO_H2();
	//public PersonDAO pd = new PersonDAO_Mongo();
	//public PersonDAO pd = new PersonDAO_Mock();
	//public PersonDAO pd = new PersonDAO_NET();

	//public PersonDAO pd = new PersonDAO_MySQL();
	//public PersonDAO pd = new PersonDAO_XML_File();
	//public PersonDAO pd = new PersonDAOF_CSVauto();
	//public PersonDAO pd = new PersonDAOF_YAMLauto();
	
	public PersonDAO pd = new PersonDAO_Hibernate();


	public PersonTableModel() 
	{
		if (pd!=null)
		{
			rr = pd.read();
		}
		
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		return rr.size();
	}

	@Override
	public String getColumnName(int col) 
	{
		String[] name = {"ID","FName","LName","Age"};
		return name[col];
	}

	@Override
	public Object getValueAt(int row, int col) 
	{
		Person p = rr.get(row);
		Object ret = null;
		switch(col)
		{
		case 0: ret = p.id; break;
		case 1: ret = p.fname; break;
		case 2: ret = p.lname; break;
		case 3: ret = p.age; break;
		}
		return ret;
	}
}
