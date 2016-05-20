package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dal.Person;

public class ConvertorYaml_Manual implements Convertor
{
	@Override
	public void toFormat(ArrayList<Person> rr) 
	{
		try {			

			Chooser chooser = new Chooser();
			File ff = chooser.save();
			FileWriter fw = new FileWriter(ff);		
			String str = "";
			for (Person p : rr)
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
		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}		
	}

	@Override
	public ArrayList<Person> fromFormat() 
	{
		ArrayList<Person> rr = new ArrayList<>();
		Chooser chooser = new Chooser();
		File ff = chooser.load();
		try 
		{	
			Scanner	in = new Scanner(ff);		
			while (in.hasNextLine())
			{
				int id = 0;
				int age = 0;
				String fname = null;
				String lname = null;
				String str = "";
				str = in.nextLine();
				while(!str.contains("age:"))
				{
					str += in.nextLine();	
				}				
				id = Integer.parseInt(str.substring(str.indexOf("id") + 3, str.indexOf("fname")));
				fname = str.substring(str.indexOf("fname") + 6, str.indexOf("lname"));	
				lname = str.substring(str.indexOf("lname") + 6, str.indexOf("age"));	
				age = Integer.parseInt(str.substring(str.indexOf("age") + 4));
				Person p = new Person(id,fname,lname,age);
				rr.add(p);

			}
			in.close();
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
		return rr;
	}

}
