package person.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;

public class PersonDAOF_YAMLauto implements PersonDAO
{
	final String PATH = "d:/java/person_auto.yaml";
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
		YamlReader reader;
		try {

			File fr = new File(PATH);
			reader = new YamlReader(new FileReader(fr));
			while (true) 
			{
				Person p;
				p = (Person) reader.read();

				if (p == null) break;
				ar.add(p);			
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("can't read from file " + PATH);
		} 
		catch (YamlException e) 
		{
			System.out.println("can't read from file " + PATH);
		} 
		return ar;
	}

	public void writeToFile()
	{
		try 
		{
			File fw = new File (PATH);
			YamlWriter writer = new YamlWriter(new FileWriter(fw));
			for (Person p: ar)
			{
				writer.write(p);
			}
			writer.close();
		} catch (IOException e) 
		{
			System.out.println("can't write to file " + PATH);
		} 
	}
}
