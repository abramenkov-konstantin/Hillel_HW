package class_chat_timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.Timer;

public class ChatClientWithoutGUI 
{
	DataInputStream reader;
	DataOutputStream writer;
	Scanner scanner;
	Timer timer;
	Socket socket = null;
	
	public ChatClientWithoutGUI() 
	{
		try 
		{
			socket = new Socket("localhost", 7777);
			System.out.println("Client: Connection established");
		
			timer = new Timer(50, new TAction());
			timer.start();
		
			writer = new DataOutputStream(socket.getOutputStream());
			scanner = new Scanner(System.in);
			while(true)
			{
				String messageOut = scanner.nextLine();
				writer.writeUTF(messageOut);
				System.out.println("Client: Sent to server: " + messageOut);
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
				reader = new DataInputStream(socket.getInputStream());
				if( socket.getInputStream().available() > 0 )
				{
					String messageIn = reader.readUTF();
					System.out.println("Client: Received from server: " + messageIn);
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
