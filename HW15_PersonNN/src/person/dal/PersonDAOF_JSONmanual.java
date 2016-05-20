package person.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonDAOF_JSONmanual implements PersonDAO
{
	final String PATH = "d:/java/person_auto.json";
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
		try 
		{
			//Gson gs = new Gson();
			Scanner sc;
			sc = new Scanner(new File(PATH));
			//String str = sc.nextLine();
			// тут будет разбор строки
			
			
			
			//ar = gs.fromJson(str, new TypeToken<ArrayList<Person>>(){}.getType());
			sc.close();
		}
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
			System.out.println("Can't read from file " + PATH);
		}
		return ar;
	}

	public void writeToFile ()
	{
		//try 
		//{
			//Gson gs = new Gson();
			//String str = gs.toJson(ar);
			//FileWriter fw = new FileWriter(PATH);
			//fw.write(str);
			//fw.flush();
			//fw.close();
		//} 
		//catch (IOException e1) 
		//{
		//	e1.printStackTrace();
		//	System.out.println("Can't write to file " + PATH);
		//}			
	}
}
