package person.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import person.dal.Person;
import person.dal.PersonDAO;
import person.dal.PersonDAO_CSV_File;
import person.dal.PersonDAO_H2;
import person.dal.PersonDAO_XML_File;
import person.model.PersonTableModel;


public class XPanel extends JPanel 
{
	protected JLabel l_id;
	protected JLabel l_fname;
	protected JLabel l_lname;
	protected JLabel l_age;

	protected JTextField text_id;
	protected JTextField text_fname;
	protected JTextField text_lname;
	protected JTextField text_age;

	protected JButton btn_create;
	protected JButton btn_read;
	protected JButton btn_update;
	protected JButton btn_delete;
	protected JButton btn_toXML;
	protected JButton btn_toJSON;
	protected JButton btn_toCSV;
	protected JButton btn_fromXML;
	protected JButton btn_fromJSON;
	protected JButton btn_fromCSV;


	PersonDAO pd = new PersonDAO_H2();

	PersonTableModel ptm = null;
	JTable tbl = null;
	JScrollPane scr = null;
	private static final long serialVersionUID = 1L;

	public XPanel() throws SQLException
	{
		setLayout(new GridLayout(2, 1));

		ptm = new PersonTableModel();
		tbl = new JTable(ptm);
		scr = new JScrollPane (tbl);
		scr.setBounds(0, 0, 450, 400);
		add(scr);

		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1));

		JPanel jp_t = new JPanel();
		jp_t.setLayout(new GridLayout(2, 4));
		l_id = new JLabel("ID");
		l_fname = new JLabel("FName");
		l_lname = new JLabel("LName");
		l_age = new JLabel("Age");
		text_id = new JTextField();
		text_fname = new JTextField();
		text_lname = new JTextField();
		text_age = new JTextField();
		jp_t.add(l_id);
		jp_t.add(l_fname);
		jp_t.add(l_lname);
		jp_t.add(l_age);
		jp_t.add(text_id);
		jp_t.add(text_fname);
		jp_t.add(text_lname);
		jp_t.add(text_age);		 

		JPanel jp_b = new JPanel();
		jp_b.setLayout(new GridLayout(2, 2));
		btn_create = new JButton("Create");
		btn_create.addActionListener(new Create());
		btn_read = new JButton("Read");
		btn_read.addActionListener(new Read());
		btn_update = new JButton("Update");
		btn_update.addActionListener(new Update());
		btn_delete = new JButton("Delete");
		btn_delete.addActionListener(new Delete());

		JPanel jp_b2 = new JPanel();
		jp_b2.setLayout(new GridLayout(3, 2));


		btn_toXML = new JButton("toXML");
		btn_toXML.addActionListener(new ToXML());
		btn_toJSON = new JButton("toJSON");
		btn_toJSON.addActionListener(new ToJSON());
		btn_toCSV = new JButton("toCSV");
		btn_toCSV.addActionListener(new ToCSV());
		btn_fromXML = new JButton("fromXML");
		btn_fromXML.addActionListener(new FromXML());
		btn_fromJSON = new JButton("FromJSON");
		btn_fromJSON.addActionListener(new FromJSON());
		btn_fromCSV = new JButton("FromCSV");
		btn_fromCSV.addActionListener(new FromCSV());

		jp.add(jp_b);
		jp_b.add(btn_create);
		jp_b.add(btn_read);
		jp_b.add(btn_update);
		jp_b.add(btn_delete);

		jp.add(jp_b2);
		jp_b2.add(btn_toXML);
		jp_b2.add(btn_fromXML);
		jp_b2.add(btn_toJSON);
		jp_b2.add(btn_fromJSON);
		jp_b2.add(btn_toCSV);
		jp_b2.add(btn_fromCSV);

		jp.add(jp_t);
		jp.add(jp_b);
		jp.add(jp_b2);

		add(jp);
	}

	//---------------
	// Create
	//---------------
	/*public class Create implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id1 = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());
			pd.create(new Person(id1, fname1, lname1, age1));
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}*/
	//---------------
	// Create New (based on rr)
	//---------------
	public class Create implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int id1 = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());
			ptm.rr.add(new Person(id1, fname1, lname1, age1));
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}

	//---------------
	// Read
	//---------------
	/*public class Read implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			pd.read();
			//	ptm.rr = ptm.pd.read();
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}*/
	//---------------
	// Read New (based on rr)
	//---------------
	public class Read implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			ptm.rr = pd.read();
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}

	//---------------
	// Update
	//---------------
	/*public class Update implements ActionListener
	{
		protected int idToUpdate;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{

			int idToUpdate = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());
			pd.update(new Person(idToUpdate, fname1, lname1, age1));
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}*/
	//---------------
	// Update New (based on rr)
	//---------------
	public class Update implements ActionListener
	{
		protected int idToUpdate;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{

			int idToUpdate = Integer.parseInt(text_id.getText());
			String fname1 = text_fname.getText();
			String lname1 = text_lname.getText();
			int age1 = Integer.parseInt(text_age.getText());
			pd.update(new Person(idToUpdate, fname1, lname1, age1));
			ptm.rr = pd.read();
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}

	//---------------
	// Delete
	//---------------
	public class Delete implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int idToDel = Integer.parseInt(text_id.getText());
			Person pToDel = new Person(idToDel, "", "", 0);
			pd.delete(pToDel);
			tbl.repaint();
			tbl.setModel(new PersonTableModel());
			tbl.repaint();
		}
	}


	//---------------
	// To XML
	//---------------
	public class ToXML implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				XMLEncoder xe = new XMLEncoder(new FileOutputStream(new File("c:/person.xml")));
				xe.writeObject(ptm.rr);
				xe.flush();
				xe.close();
				System.out.println("file C:\\person.xml created");
			}
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	//---------------
	// From XML
	//---------------
	public class FromXML implements ActionListener 
	{
		//public ArrayList<Person> rr = null;
		@Override
		public void actionPerformed(ActionEvent arg0) 
		{
			try 
			{
				XMLDecoder xe = new XMLDecoder(new FileInputStream(new File("c:/person.xml")));
				ptm.rr = (ArrayList<Person>) xe.readObject();
				xe.close();
				tbl.revalidate();
				tbl.repaint();
			} 
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	//---------------
	// To GSON
	//---------------
	public class ToJSON implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Gson gs = new Gson();
				String str = gs.toJson(ptm.rr);
				FileWriter fw = new FileWriter("c:/person.json");
				fw.write(str);
				fw.flush();
				fw.close();
				System.out.println("file C:\\person.json created");
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}		
		}
	}

	//---------------
	// From GSON
	//---------------
	public class FromJSON implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			try 
			{
				Gson gs = new Gson();
				Scanner sc;
				sc = new Scanner(new File("c:/person.json"));
				String str = sc.nextLine();
				ptm.rr = gs.fromJson(str,  new TypeToken<ArrayList<Person>>() {}.getType());

				//gs.from						
				//ptm.rr = gs.fromJson(str, new TypeToken<ArrayList<Person>>(){}.getType());
				//sc.close();
				tbl.revalidate();
				tbl.repaint();
				sc.close();
			}
			catch (FileNotFoundException e1) 
			{
				e1.printStackTrace();
			}
		}	
	}

	//---------------
	// To CSV
	//---------------
	public class ToCSV implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
				for (Person p : ptm.rr)
			{
			System.out.println("file C:\\person.csv created");
			}
			try
			{
				FileWriter writer = new FileWriter("c:/person.csv");
				for (Person p : ptm.rr)
				{
					//writer.append(p.id + ',' + p.fname + ',' + p.lname + ',' + p.age + '\n');
					writer.append(""+ p.id);
					writer.append(',');
					writer.append(p.fname);
					writer.append(',');
					 writer.append(p.lname);
						writer.append(',');
					 writer.append(""+ p.age);
					 writer.append('\n');
					
				}
				writer.append(" sasdads");
				//writer.flush();
				writer.close();
				System.out.println("file C:\\person.csv created");
			}
			catch(IOException e)
			{
				e.printStackTrace();
				System.out.println("problem");
			} 
		}
	}


//---------------
// From CSV
//---------------
public class FromCSV implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
	}
}

public class ToXML1 implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		PersonDAO pd1 = new PersonDAO_XML_File(); //это мост (Bridge)
		System.out.println("TestXML");

		pd1.create (new Person (105, "NewVova", "NewPupkins", 56));

		ArrayList<Person> rr = pd1.read();
		for (Person p : rr) 
		{

			System.out.println(p);
		}			
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("person");
			doc.appendChild(rootElement);

			//ArrayList<Person> rr = ptm.pd.read();
			for (Person p : rr) 
			{

				// id element
				String id1 = ""+ p.id;
				Element id = doc.createElement("Id");
				id.appendChild(doc.createTextNode(id1));
				rootElement.appendChild(id);

				// fname element
				Element fname = doc.createElement("FName");
				fname.appendChild(doc.createTextNode(p.fname));
				rootElement.appendChild(fname);

				// lname element
				Element lname = doc.createElement("LName");
				lname.appendChild(doc.createTextNode(p.lname));
				rootElement.appendChild(lname);

				// Age element
				String age1 = ""+ p.age;
				Element age = doc.createElement("Age");
				age.appendChild(doc.createTextNode(age1));
				rootElement.appendChild(age);
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\person.xml"));
			transformer.transform(source, result);

			System.out.println("file C:\\person.xml created");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
}