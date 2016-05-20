package command;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dal.Person;

public class ConvertorJSON implements Convertor
{
	@Override
	public void toFormat(ArrayList<Person> rr) 
	{
		try 
		{
			Chooser chooser = new Chooser();
			File ff = chooser.save();
			Gson gs = new Gson();
			String str = gs.toJson(rr);
			FileWriter fw = new FileWriter(ff);
			fw.write(str);
			fw.flush();
			fw.close();
		} 
		catch (IOException e1) 
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
			Gson gs = new Gson();
			Scanner sc = new Scanner(ff);			
			String str = sc.nextLine();
			rr = gs.fromJson(str, new TypeToken<ArrayList<Person>>(){}.getType());
			sc.close();
		}
		catch (FileNotFoundException e1) 
		{
			JOptionPane.showMessageDialog(null, "You did not choose file");
		}		
		return rr;
	}
}
