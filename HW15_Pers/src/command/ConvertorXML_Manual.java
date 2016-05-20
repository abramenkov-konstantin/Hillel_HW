package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dal.Person;

public class ConvertorXML_Manual implements Convertor
{

	@Override
	public void toFormat(ArrayList<Person> rr) 
	{
		String str = "";
		try 
		{			
			Chooser chooser = new Chooser();
			File ff = chooser.save();
			FileWriter fw = new FileWriter(ff);
			str += "<?xml version=\"1.1\" encoding=\"UTF-8\" ?>\n";
			str += "<Persons>\n";
			for (Person p : rr)
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
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
	}

	@Override
	public ArrayList<Person> fromFormat() 
	{
		ArrayList<Person> rr = new ArrayList<>();		
		try 
		{	
			Chooser chooser = new Chooser();
			File ff = chooser.load();
			Scanner	in = new Scanner(ff);		
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
					rr.add(p);
				}
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
