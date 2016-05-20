package person.view;

import java.util.ArrayList;

import person.dal.Person;
import person.dal.PersonDAO;
import person.dal.PersonDAO_CSV_File;
import person.dal.PersonDAO_Mongo;
import person.dal.PersonDAO_XML_File;



public class XXXTest 
{
	public static void main(String[] args)
	{
		PersonDAO pd = new PersonDAO_CSV_File();
		
		System.out.println("Test");
		
		ArrayList<Person> rr = pd.read();
		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}
}
