package dal;

import java.util.ArrayList;

import command.Convertor;
import command.ConvertorCSV;

public class PersonDAO_CSV implements PersonDAO
{
	@Override
	public void create(Person p) 
	{
		Convertor csv = new ConvertorCSV();
		ArrayList<Person> rr = csv.fromFormat();
		rr.add(p);
		csv.toFormat(rr);
	}

	@Override
	public ArrayList<Person> read() 
	{
		Convertor csv = new ConvertorCSV();
		ArrayList<Person> rr = csv.fromFormat();
		return rr;
	}

	@Override
	public void update(Person p) 
	{
		Convertor csv = new ConvertorCSV();
		ArrayList<Person> rr = csv.fromFormat();
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
		Convertor csv = new ConvertorCSV();
		ArrayList<Person> rr = csv.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				rr.remove(p);
				break;
			}
		}
		csv.toFormat(rr);
	}

}
