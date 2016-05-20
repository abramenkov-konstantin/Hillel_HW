package person.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class PersonDAOF_YAMLmanual implements PersonDAO
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
		File f =  new File (PATH);
		try 
		{	
			Scanner	scanner = new Scanner(f);		
			while (scanner.hasNextLine())
			{
				int id = 0;
				int age = 0;
				String fname = null;
				String lname = null;
				String str = "";
				str = scanner.nextLine();
				while(!str.contains("age:"))
				{
					str += scanner.nextLine();	
				}				
				id = Integer.parseInt(str.substring(str.indexOf("id") + 3, str.indexOf("fname")));
				fname = str.substring(str.indexOf("fname") + 6, str.indexOf("lname"));	
				lname = str.substring(str.indexOf("lname") + 6, str.indexOf("age"));	
				age = Integer.parseInt(str.substring(str.indexOf("age") + 4));
				Person p = new Person(id,fname,lname,age);
				ar.add(p);

			}
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("can't read from file " + PATH);
		} 
		return ar;
	}

	public void writeToFile()
	{
		try 
		{
			File f = new File (PATH);
			FileWriter fw = new FileWriter(f);		
			String str = "";
			for (Person p : ar)
			{
				str += "!dal.Person\n";
				str += "id:" + p.id + "\n";
				str += "fname:" + p.fname + "\n";
				str += "lname:" + p.lname + "\n";
				str += "age:" + p.age + "\n";		
			}	
			fw.write(str);
			fw.flush();
			fw.close();

		} catch (IOException e) 
		{
			System.out.println("can't write to file " + PATH);
		} 
	}
}
