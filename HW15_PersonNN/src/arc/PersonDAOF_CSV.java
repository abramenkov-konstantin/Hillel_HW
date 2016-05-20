package arc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import person.dal.Person;
import person.dal.PersonDAO;


public class PersonDAOF_CSV implements PersonDAO 
{
	public static void main(String[] args)
	{
		PersonDAO pd = new PersonDAOF_CSV();
		System.out.println("TestCSV");

		ArrayList<Person> rr = pd.read();
		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}


	@Override
	public void create(Person p) //Write to CSV
	{


	}

	@Override
	public ArrayList<Person> read() //Read from CSV 
	{
		int id, age;
		String fname, lname;
		ArrayList<Person> ar = new ArrayList<Person>();
		//Input file which needs to be parsed
		String fileToParse = "C:\\person.csv";
		BufferedReader fileReader = null;

		//Delimiter used in CSV file
		final String DELIMITER = ",";
		try
		{
			String line = "";
			//Create the file reader
			fileReader = new BufferedReader(new FileReader(fileToParse));

			//Read the file line by line
			while ((line = fileReader.readLine()) != null) 
			{
				//Get all tokens available in line
				String[] tokens = line.split(DELIMITER);

				id = Integer.parseInt(tokens[0]);
				fname = tokens[1];
				lname = tokens[2];
				age = Integer.parseInt(tokens[3]);
				ar.add( new Person(id, fname, lname, age));
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally
		{
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ar;
	}

	@Override
	public void update(Person p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Person p) {
		// TODO Auto-generated method stub

	}

}
