package command;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


import java.util.ArrayList;

import javax.swing.JOptionPane;

import dal.Person;

public class ConvertorXML implements Convertor
{	
	@Override
	public void toFormat(ArrayList<Person> rr) 
	{		
		try 
		{
			Chooser chooser = new Chooser();
			File ff = chooser.save();
			XMLEncoder xe = new XMLEncoder(new FileOutputStream(ff));
			xe.writeObject(rr);
			xe.flush();
			xe.close();
		} 
		catch (FileNotFoundException e) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Person> fromFormat() 
	{	
		ArrayList<Person> rr = new ArrayList<>();
		try 
		{	
			Chooser chooser = new Chooser();
			File ff = chooser.load();
			XMLDecoder xe = new XMLDecoder(new FileInputStream(ff));
			rr = (ArrayList<Person>) xe.readObject();
			xe.close();
		} 
		catch (FileNotFoundException e1) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}
		return rr;
	}

}
