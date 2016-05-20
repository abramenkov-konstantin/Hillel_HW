package command;

import java.util.ArrayList;

import dal.Person;

public interface Convertor 
{
	public void toFormat(ArrayList<Person> rr);
	public ArrayList<Person> fromFormat();
}
