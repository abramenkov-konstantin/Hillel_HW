package dal;

import java.util.ArrayList;
import command.Convertor;
import command.ConvertorJSON;

public class PersonDAO_JSON implements PersonDAO
{
	@Override
	public void create(Person p) 
	{
		Convertor json = new ConvertorJSON();
		ArrayList<Person> rr = json.fromFormat();
		rr.add(p);
		json.toFormat(rr);
	}

	@Override
	public ArrayList<Person> read() 
	{
		Convertor json = new ConvertorJSON();
		ArrayList<Person> rr = json.fromFormat();
		return rr;
	}

	@Override
	public void update(Person p) 
	{
		Convertor json = new ConvertorJSON();
		ArrayList<Person> rr = json.fromFormat();
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
		Convertor json = new ConvertorJSON();
		ArrayList<Person> rr = json.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				rr.remove(p);
				break;
			}
		}
		json.toFormat(rr);
	}

}
