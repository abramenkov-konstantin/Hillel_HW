package person.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonDAO_Mock implements PersonDAO
{
	Map<Integer, Person> rr=new HashMap <Integer, Person>();

	public PersonDAO_Mock() 
	{
		rr.put(10, new Person (10, "VasyaMock", "PupkinMock", 15));
		rr.put(20, new Person (20, "VovaMock", "PipkinMock", 25));
		rr.put(30, new Person (30, "PetyaMock", "PutkinMock", 35));
		rr.put(40, new Person (40, "VanyaMock", "KorkinMock", 45));
	}

	@Override
	public void create(Person p) 
	{
		rr.put(p.id, p);
	}

	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> ar = new ArrayList<>(rr.values());
		return ar;
	}

	@Override
	public void update(Person p) 
	{
		rr.put(p.id, p);
	}

	@Override
	public void delete(Person p) 
	{
		rr.remove(p.id, p);
	}
}