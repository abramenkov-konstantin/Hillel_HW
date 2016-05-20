package class_chat_thread;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.Timer;

public class ChatServer
{
	ArrayList<Socket> cc = new ArrayList<Socket>();

	public ChatServer() 
	{
		try 
		{
			Timer tm = new Timer(50, new TAction());
			tm.start();

			ServerSocket ss = new ServerSocket(7777);
			while(true)
			{
				Socket cs = ss.accept();
				cc.add(cs);
			}
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
				for (Socket s : cc) 
				{
					DataInputStream in = new DataInputStream(s.getInputStream());
					if( s.getInputStream().available() > 0 )
					{
						String str = in.readUTF();
						System.out.println("from => " + str);

						//for (Socket so : cc)
						for(int i = 0; i < cc.size(); i++)
						{
							
							DataOutputStream out = new DataOutputStream(cc.get(i).getOutputStream());
							out.writeUTF(cc.get(i).getPort() + str);
						}
					}
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
