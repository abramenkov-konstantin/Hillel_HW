package command;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;



import dal.Person;

public class ConvertorCSV implements Convertor 
{	
	@Override
	public void toFormat(ArrayList<Person> rr) 
	{
		try 
		{	
			Chooser chooser = new Chooser();
			File ff = chooser.save();
			CSVPrinter cp = new CSVPrinter(new FileWriter(ff), CSVFormat.EXCEL);
			for (Person p: rr)
			{
				cp.printRecord(p);
			}
			cp.flush();
			cp.close();

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
		try 
		{
			Chooser chooser = new Chooser();
			File ff = chooser.load();
			CSVParser csv = CSVParser.parse(ff, StandardCharsets.UTF_8, CSVFormat.EXCEL);			
			List<CSVRecord> list = csv.getRecords();
			for (CSVRecord record: list)
			{
				String str = record.get(0);
				int id = Integer.parseInt(str.substring(str.indexOf("id") + 3, str.indexOf("fname") - 2));
				String fname = str.substring(str.indexOf("fname") + 6, str.indexOf("lname") - 2);	
				String lname = str.substring(str.indexOf("lname") + 6, str.indexOf("age") - 2);	
				int age = Integer.parseInt(str.substring(str.indexOf("age") + 4, str.indexOf("]")));
				Person p = new Person(id,fname,lname,age);
				rr.add(p);
			}

		} 
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}		
		return rr;
	}



}
