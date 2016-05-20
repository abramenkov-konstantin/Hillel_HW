package person.dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PersonDAO_JSON implements PersonDAO 
{
	final String PATH = "c:/ccc.json";
	
	public static void main(String[] args)
	{
		PersonDAO pd = new PersonDAO_JSON(); //это мост (Bridge)
		System.out.println("Test JSON");
		
		pd.create (new Person (1, "Vova", "Pupkins", 10));
		pd.create (new Person (2, "NewVova", "NewPupkins", 20));
		pd.create (new Person (3, "NewNewVova", "MewNewPupkins", 30));
		
		ArrayList<Person> rr = pd.read();
		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}
		
	
	@Override
	public void create(Person p) 
	{
		// TODO Auto-generated method stub
	}

	public ArrayList<Person> write() 
	{
		ArrayList<Person> rr = null;
		try 
		{
			Gson gs = new Gson();
			String str = gs.toJson(rr);
			FileWriter fw = new FileWriter(PATH);
			fw.write(str);
			fw.flush();
			fw.close();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}			
		return rr;
	}
	
	
	@Override
	public ArrayList<Person> read() 
	{
		ArrayList<Person> rr = null;
		try 
		{
			Gson gs = new Gson();
			Scanner sc;
			sc = new Scanner(new File(PATH));
			String str = sc.nextLine();
			rr = gs.fromJson(str, new TypeToken<ArrayList<Person>>(){}.getType());
			sc.close();
		}
		catch (FileNotFoundException e1) 
		{
			e1.printStackTrace();
		}
		return rr;
	}

	@Override
	public void update(Person p) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Person p) 
	{
		// TODO Auto-generated method stub
		
	}

}
