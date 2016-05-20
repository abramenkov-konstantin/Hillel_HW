package class_chat_thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.Timer;

public class ChatClient 
{
	Socket cs = null;
	public ChatClient() 
	{
		try 
		{
			cs = new Socket("localhost", 7777);

			Timer tm = new Timer(50, new TAction());
			tm.start();

			DataOutputStream out = new DataOutputStream(cs.getOutputStream());
			Scanner sc = new Scanner(System.in);
			while(true)
			{
				String str = sc.nextLine();
				out.writeUTF(str);
			}
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
				DataInputStream in = new DataInputStream(cs.getInputStream());
				if( cs.getInputStream().available() > 0 )
				{
					String str = in.readUTF();
					System.out.println("from => " + str);
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}

		}
	}
}
