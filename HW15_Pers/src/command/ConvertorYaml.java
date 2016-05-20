package command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dal.Person;


public class ConvertorYaml implements Convertor
{
	@Override
	public void toFormat(ArrayList<Person> rr)
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
}
