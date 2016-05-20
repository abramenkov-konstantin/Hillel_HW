package dal;

import java.util.ArrayList;

import command.Convertor;
import command.ConvertorXML;

public class PersonDAO_XML implements PersonDAO
{
	@Override
	public void create(Person p) 
	{
		Convertor xml = new ConvertorXML();
		ArrayList<Person> rr = xml.fromFormat();
		rr.add(p);
		xml.toFormat(rr);
	}

	@Override
	public ArrayList<Person> read() 
	{
		Convertor xml = new ConvertorXML();
		ArrayList<Person> rr = xml.fromFormat();
		return rr;
	}

	@Override
	public void update(Person p) 
	{
		Convertor xml = new ConvertorXML();
		ArrayList<Person> rr = xml.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				iterator.fname = p.fname;
				iterator.lname = p.lname;
				iterator.age = p.age;
				break;
			}
		}
	}

	@Override
	public void delete(Person p) 
	{
		Convertor xml = new ConvertorXML();
		ArrayList<Person> rr = xml.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				rr.remove(p);
				break;
			}
		}
		xml.toFormat(rr);
	}

}
