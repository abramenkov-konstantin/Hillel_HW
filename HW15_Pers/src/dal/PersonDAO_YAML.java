package dal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class PersonDAO_YAML implements PersonDAO
{
	@Override
	public void writeToFile(ArrayList<Person> rr)
	{
		try 
		{
			Chooser chooser = new Chooser();
			File ff = chooser.save();	
			YamlWriter writer = new YamlWriter(new FileWriter(ff));
			for (Person p: rr)
			{
				writer.write(p);
			}
			writer.close();
		} catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		} 
		catch (YamlException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
	}

	@Override
	public ArrayList<Person> fromFormat() 
	{
		ArrayList<Person> rr = new ArrayList<>();
		YamlReader reader;
		try {
			Chooser chooser = new Chooser();
			File ff = chooser.load();
			reader = new YamlReader(new FileReader(ff));
			while (true) 
			{
				Person p = (Person) reader.read();
				if (p == null) break;
				rr.add(p);			
			}
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		} 
		catch (YamlException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
		return rr;
	}
	
	
	
	

	@Override
	public void create(Person p) 
	{
		Convertor yaml = new ConvertorYaml();
		ArrayList<Person> rr = yaml.fromFormat();
		rr.add(p);
		yaml.toFormat(rr);
	}

	@Override
	public ArrayList<Person> read() 
	{
		Convertor yaml = new ConvertorYaml();
		ArrayList<Person> rr = yaml.fromFormat();
		return rr;
	}

	@Override
	public void update(Person p) 
	{
		Convertor yaml = new ConvertorYaml();
		ArrayList<Person> rr = yaml.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				iterator.fname = p.fname;
				iterator.lname = p.lname;
				iterator.age = p.age;
				break;
			}
		}
	}

	@Override
	public void delete(Person p) 
	{
		Convertor yaml = new ConvertorYaml();
		ArrayList<Person> rr = yaml.fromFormat();
		for(Person iterator: rr)
		{
			if (iterator.id == p.id)
			{
				rr.remove(p);
				break;
			}
		}
		yaml.toFormat(rr);
	}
}
