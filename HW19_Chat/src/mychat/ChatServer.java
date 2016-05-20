package mychat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public class ChatServer
{
	ArrayList<PrintWriter> clientOutputStream;
	//Map<Integer, PrintWriter> rr = new HashMap <Integer, PrintWriter>();

	public class ClientHandler implements Runnable
	{
		BufferedReader reader;
		Socket socket;

		public ClientHandler(Socket clientSocket) 
		{
			try
			{
				socket = clientSocket;
				InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
				reader = new BufferedReader(isReader);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}

		@Override
		public void run() 
		{
			String message;
			try
			{
				while((message = "Port: " + socket.getPort() + ": " + reader.readLine()) != null)
				{
					System.out.println("read " + message);
					tellEveryone(message);
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

	public void go()
	{
		clientOutputStream = new ArrayList<PrintWriter>();
		try 
		{ 
			ServerSocket serverSocket = new ServerSocket(7781);
			while (true)
			{
				Socket clientSocket = serverSocket.accept();
				PrintWriter writer = new PrintWriter (clientSocket.getOutputStream());
				clientOutputStream.add(writer);
				Thread t = new Thread(new ClientHandler(clientSocket));
				t.start();
				System.out.println("got a connection");
				//serverSocket.close();
			}
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	public void tellEveryone (String message)
	{
		Iterator<PrintWriter> it = clientOutputStream.iterator();
		while (it.hasNext())
		{
			try
			{
				
				PrintWriter writer = (PrintWriter) it.next();
				writer.println(message);
				writer.flush();
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
