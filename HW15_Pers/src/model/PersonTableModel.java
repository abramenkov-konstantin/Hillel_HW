package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import dal.Person;
public class PersonTableModel extends AbstractTableModel 
{
	private static final long serialVersionUID = 4337981302070229811L;

	ArrayList <Person> rr;
	public PersonTableModel(ArrayList <Person> rr) 
	{
		this.rr = rr;
	}

	@Override
	public int getColumnCount() 
	{
		return 4;
	}

	@Override
	public int getRowCount() 
	{
		int size = 0;
		if (rr != null)
			size = rr.size();
		
		return size;
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
		switch (col) 
		{
		case 0: ret = p.id;    break;
		case 1: ret = p.fname; break;
		case 2: ret = p.lname; break;
		case 3: ret = p.age;   break;
		}
		return ret;
	}

}
