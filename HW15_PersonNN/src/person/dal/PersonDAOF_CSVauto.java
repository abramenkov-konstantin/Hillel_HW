package person.dal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonDAOF_CSVauto  implements PersonDAO
{
	final String PATH = "d:/java/person_manual.csv";
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
		String DELIMITER = ",";
		BufferedReader br = null;
		ar = new ArrayList<>(); 
		try 
		{
			String line = "";
			br = new BufferedReader(new FileReader(PATH));
			//br.readLine();
			while ((line = br.readLine()) != null) 
			{
				String[] tokens = line.split(DELIMITER);
				if (tokens.length > 0) 
				{
					Person p  = new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]));
					ar.add(p);
				}
			}
			br.close();
			System.out.println("file " + PATH + " read successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("can't find file " + PATH);
		}
		return ar;
	}

	public void writeToFile ()
	{
		try
		{
			FileWriter writer = new FileWriter(PATH);
			for (Person p : ar)
			{
				writer.append(""+ p.id + ',' + p.fname + ',' + p.lname + ',' + p.age + '\n');
			}
			writer.flush();
			writer.close();
			System.out.println("file " + PATH + " saved");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("can't write to file " + PATH);
		} 
	}
}
