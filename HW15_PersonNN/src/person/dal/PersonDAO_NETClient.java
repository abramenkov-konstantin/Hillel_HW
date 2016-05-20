package person.dal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.Timer;


public class PersonDAO_NETClient implements PersonDAO
{
	DataInputStream reader;
	DataOutputStream writer;
	Scanner scanner;
	Timer timer;
	Socket socket = null;
	String messageOut;
	String messageIn;

	public static void main(String[] args)
	{
		PersonDAO pd = new PersonDAO_NETClient();
		System.out.println("TestNet");

		pd.create (new Person (106, "VovaNet", "PupkinsNet", 56));

		ArrayList<Person> rr = pd.read();

		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}

	public void getNetworking()
	{
		try 
		{
			socket = new Socket("localhost", 7777);
			System.out.println("Networking established");

			timer = new Timer(50, new TAction());
			timer.start();

			writer = new DataOutputStream(socket.getOutputStream());
			writer.writeUTF(messageOut);
		}
		catch (IOException  e) 
		{
			e.printStackTrace();
		}
	}

	class TAction implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				reader = new DataInputStream(socket.getInputStream());
				if( socket.getInputStream().available() > 0 )
				{
					messageIn = reader.readUTF();
					System.out.println("Received from server: " + messageIn);
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	@Override
	public void create(Person p) 
	{
		messageOut = "create person: " + p.id + ":" + p.fname + ":" + p.lname + ":" + p.age;
		System.out.println("Sent to server: " + messageOut);
		getNetworking();
	}

	@Override
	public ArrayList<Person> read()
	{
		ArrayList<Person> ar = new ArrayList<Person>();
		while (messageIn!="")
		{
			getNetworking();
			String[] tokens = messageIn.split(":");
			if (tokens.length > 0) 
			{
				Person p  = new Person(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]));
				ar.add(p);
				messageIn="";
			}
		}
		return ar;
	}

	@Override
	public void update(Person p)
	{
		messageOut = "update person: " + p.id + ":" + p.fname + ":" + p.lname + ":" + p.age;
		System.out.println("Sent to server: " + messageOut);
		getNetworking();
	}

	@Override
	public void delete(Person p) 
	{
		messageOut = "delete person: " + p.id;
		System.out.println("Sent to server: " + messageOut);
		getNetworking();
	}
}
