package arc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import person.dal.Person;
import person.dal.PersonDAO;

public class PersonDAOF_CSVmanual implements PersonDAO 
{
	public static void main(String[] args) throws UnknownHostException 
	{
		PersonDAO pd = new PersonDAOF_CSVmanual();

		pd.create(new Person(1, "Vasya", "Pup", 10));
		pd.create(new Person(2, "Vova", "Vasil", 11));
		pd.create(new Person(3, "Petya", "Brivkin", 12));
		pd.create(new Person(4, "Kolya", "Ivanov", 12));

		pd.update(new Person(4, "NewKolya", "NewIvanov", 15));
		pd.delete(new Person(3, "Petya", "Brivkin", 12));

		ArrayList<Person> p = pd.read();
		for (Person person : p) 
		{
			System.out.println(person);
		}
	}

	//---------------
		// From CSV
		//---------------
		public class FromCSV implements ActionListener
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				
			}
		}





		//---------------
		// To CSV
		//---------------
		public class ToCSV implements ActionListener
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				ArrayList<Person> ar = new ArrayList<Person>();
				try
				{
					FileWriter writer = new FileWriter("c:/person.csv");
					for (Person p : ar)
					{
						writer.append(""+ p.id + ',' + p.fname + ',' + p.lname + ',' + p.age + '\n');
					}
					writer.flush();
					writer.close();
					System.out.println("file C:\\person.csv created");
				}
				catch(IOException e)
				{
					e.printStackTrace();
					System.out.println("problem");
				} 
			}
		}
	
	
	
	
	
	@Override
	public void create(Person p) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Person> read() 
	{
		String DELIMITER = ",";
		BufferedReader br = null;
		try 
		{
			String line = "";
			br = new BufferedReader(new FileReader("c:/person.csv"));
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split(DELIMITER);
				if (tokens.length > 0) {
					Person p  = new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]));
			//		pd.add(p);
				}
			}
			br.close();
			//tbl.revalidate();
			//tbl.repaint();
			System.out.println("file C:\\person.csv read successfully");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("problem");
		}
	
		return null;
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
