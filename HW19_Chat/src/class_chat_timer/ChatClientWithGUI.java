package class_chat_timer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class ChatClientWithGUI 
{
	JTextArea incoming;
	JTextField outgoing;
	DataInputStream reader;
	DataOutputStream writer;
	Socket socket;
	Timer timer;

	public ChatClientWithGUI() 
	{
		//GUI
		JFrame  frame = new JFrame ("ClientChat");
		JPanel mainPanel = new JPanel();
		incoming = new JTextArea(15,50);
		incoming.setLineWrap(true);
		incoming.setWrapStyleWord(true);
		incoming.setEditable(false);
		JScrollPane qScroller = new JScrollPane(incoming);
		outgoing = new JTextField(20);
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new SendButtonListener());
		mainPanel.add(qScroller);
		mainPanel.add(outgoing);
		mainPanel.add(sendButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(600, 350);
		frame.setVisible(true);
		
		try 
		{
			socket = new Socket("localhost", 7777);
			System.out.println("Client: Connection established");
			timer = new Timer(50, new TAction());
			timer.start();
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
				writer = new DataOutputStream(socket.getOutputStream());
				String messageOut = outgoing.getText();
				if (messageOut!="")
				{
					writer.writeUTF(messageOut);
					System.out.println("Client: Sent to server: " + messageOut);
					writer.flush();
					outgoing.setText("");
					outgoing.requestFocus();
				}
			}
			catch (Exception ex) 
			{
				ex.printStackTrace();
			}
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
					incoming.append(messageIn + "\n");
					incoming.repaint();
				}
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
