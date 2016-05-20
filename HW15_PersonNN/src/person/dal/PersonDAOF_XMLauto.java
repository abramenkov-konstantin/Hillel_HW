package person.dal;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.ArrayList;

public class PersonDAOF_XMLauto implements PersonDAO
{
	final String PATH = "d:/java/person_auto.xml";
	ArrayList<Person> ar;

	@Override
	public void create(Person pToAdd) 
	{
		ar = readFromFile();
		ar.add(pToAdd);
		writeToFile();
	}

	@Override
	public ArrayList<Person> read() 
	{
		ar = readFromFile();
		return ar;
	}

	@Override
	public void update(Person pToUdate) 
	{
		ar = readFromFile();
		for (Person p : ar) 
		{
			if (p.id == pToUdate.id)
			{
				p.fname = pToUdate.fname;
				p.lname = pToUdate.lname;
				p.age = pToUdate.age;
			}
		}
		writeToFile();
	}

	@Override
	public void delete(Person pToDel) 
	{
		ar = readFromFile();
		ar.remove(pToDel);
		writeToFile();
	}

	public ArrayList<Person> readFromFile()
	{
		ArrayList<Person> ar = new ArrayList<>();
		try 
		{	
			File fr = new File(PATH);
			
			XMLDecoder xe = new XMLDecoder(new FileInputStream(fr));
			ar = (ArrayList<Person>) xe.readObject();
			xe.close();
		} 
		catch (FileNotFoundException e1) 
		{
			System.out.println("can't read from file " + PATH);
		}
		return ar;
		
	}

	public void writeToFile ()
	{
		try 
		{

			File fw = new File (PATH);
			XMLEncoder xe = new XMLEncoder(new FileOutputStream(fw));
			xe.writeObject(ar);
			xe.flush();
			xe.close();
			System.out.println("file " + PATH + " saved");
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("can't write to file " + PATH);
		}
	}

}
