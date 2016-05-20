package person.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonDAOF_XMLmanual implements PersonDAO
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
			Scanner	in = new Scanner(fr);		
			while (in.hasNextLine())
			{
				int id = 0;
				int age = 0;
				String fname = null;
				String lname = null;
				String str = "";
				str = in.nextLine();
				while(!str.contains("</age>"))
				{
					str += in.nextLine();	
					if (str.contains("</Person>"))
						break;
				}
				if (!str.contains("</Person>"))
				{
					id = Integer.parseInt(str.substring(str.indexOf("id") + 3, str.lastIndexOf("id") - 2));			
					fname = str.substring(str.indexOf("fname") + 6, str.lastIndexOf("fname") - 2);			
					lname = str.substring(str.indexOf("lname") + 6, str.lastIndexOf("lname") - 2);			
					age = Integer.parseInt(str.substring(str.indexOf("age") + 4, str.lastIndexOf("age") - 2));
					Person p = new Person(id,fname,lname,age);
					ar.add(p);
				}
			}
			in.close();
			System.out.println("File " + PATH + " read");
		} 
		catch (FileNotFoundException e1) 
		{
			System.out.println("Can't read from file " + PATH);
		}
		return ar;

	}

	public void writeToFile ()
	{
		String str = "";
		try 
		{
			File f = new File (PATH);
			FileWriter fw = new FileWriter(f);
			str += "<?xml version=\"1.1\" encoding=\"UTF-8\" ?>\n";
			str += "<Persons>\n";
			for (Person p : ar)
			{
				str += "<Person>\n";
				str += "\t<id>" + p.id + "</id>\n";
				str += "\t<fname>" + p.fname + "</fname>\n";
				str += "\t<lname>" + p.lname + "</lname>\n";
				str += "\t<age>" + p.age + "</age>\n";
				str += "</Person>\n";		
			}	
			str += "</Persons>";
			fw.write(str);
			fw.flush();
			fw.close();
			System.out.println("File " + PATH + " saved");
		} 
		catch (IOException e) 
		{
			System.out.println("Can't write to file " + PATH);
		}
	}

}
