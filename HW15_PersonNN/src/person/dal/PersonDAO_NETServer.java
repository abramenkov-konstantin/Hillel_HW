package person.dal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

public class PersonDAO_NETServer
{
	ArrayList<Socket> cc = new ArrayList<Socket>();
	ArrayList<Person> ap = new ArrayList<Person>();
	Map<Socket, String> rr = new HashMap <Socket, String>();
	DataInputStream reader;
	DataOutputStream writer;

	public PersonDAO_NETServer() 
	{
		try 
		{
			Timer tm = new Timer(50, new TAction());
			tm.start();

			ServerSocket ss = new ServerSocket(7777);
			Socket cs = ss.accept();
			System.out.println("Server: got connection");
		}
		catch (IOException e) 
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
				ServerSocket ss = new ServerSocket(7777);
				Socket s = ss.accept();
				DataInputStream reader = new DataInputStream(s.getInputStream());
				if( s.getInputStream().available() > 0 )
				{
					String str = reader.readUTF();
					System.out.println("Received from user: " + str);
					String[] tokens = str.split(":");
					if (tokens.length > 0) 
					{
						switch(tokens[0]) 
						{
						case "create person":
						{
							Person p  = new Person(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
							ap.add(p);
						}break;

						case "read person":
						{
							for(Person p : ap) 
							{
								String message = p.id + ":" + p.fname + ":" + p.lname + ":" + p.age;
								DataOutputStream writer = new DataOutputStream(s.getOutputStream());
								writer.writeUTF(message);
								System.out.println("Sent to user " + message);
							}	
						}break;

						case "update person":
						{
							Person pToUpdate  = new Person(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
							for(Person p : ap) 
							{
								if (p.id== pToUpdate.id)
									p=pToUpdate;
							}	
						}break;

						case "delete person":
						{
							Person pToDel  = new Person(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Integer.parseInt(tokens[4]));
							ap.remove(pToDel);
						}break;

						case "close connection":
						{
						}break;

						default:
						{
						}break;
						}
					}

				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}

		public void tellEveryone (String message)
		{
			try 
			{
				for(Socket s : cc) 
				{
					DataOutputStream writer = new DataOutputStream(s.getOutputStream());
					writer.writeUTF(message);
					System.out.println("Sent to user " + s.getPort() + " " + message);
				}						
			}
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
