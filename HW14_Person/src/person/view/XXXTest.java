package person.view;

import java.util.ArrayList;

import person.dal.Person;
import person.dal.PersonDAO;
import person.dal.PersonDAO_H2;

public class XXXTest 
{
	public static void main(String[] args)
	{
				PersonDAO pd = new PersonDAO_H2();
				ArrayList<Person> rr = pd.read();
				for (Person p : rr) 
				{
				System.out.println(p);	
				}
				
	}
}
