package mychat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClientMy 
{
	JTextArea incoming;
	JTextField outgoing;
	BufferedReader reader;
	PrintWriter writer;
	Socket socket;

	public void go()
	{
		JFrame  frame = new JFrame ("ClientChat");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		JButton closeButton = new JButton("Close");
		sendButton.addActionListener(new SendButtonListener());
		closeButton.addActionListener(new CloseButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		mainPanel.add(closeButton);

		setUpNetworking();

		Thread readerThread = new Thread (new IncomingReader());
		readerThread.start();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(600, 350);
		frame.setVisible(true);
	}

	private void setUpNetworking()
	{
		try 
		{
			socket = new Socket("localhost", 7781);
			reader =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			System.out.println("networking established");
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}

	}

	public class SendButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				writer.println(outgoing.getText());
				writer.flush();
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			outgoing.setText("");
			outgoing.requestFocus();
		}
	}

	public class CloseButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try
			{
				writer.close();
				reader.close();
				socket.close();
				System.out.println("networking closed");
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}


	public class IncomingReader implements Runnable
	{
		@Override
		public void run() 
		{
			String message;
			try
			{
				while ((message = reader.readLine()) !=null)
				{
					System.out.println("read " + message);
					incoming.append(message + "\n");

					incoming.repaint();
				}
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
		}
	}
}
