package arc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import person.dal.Person;
import person.dal.PersonDAO;

public class PersonDAOF_XMLauto implements PersonDAO 
{
	public static void main(String[] args)
	{
		
		PersonDAO pd = new PersonDAOF_XMLauto();
		System.out.println("TestXML");
		
		pd.create (new Person (105, "NewVova", "NewPupkins", 56));
		
		ArrayList<Person> rr = pd.read();
		for (Person p : rr) 
		{
			System.out.println(p);
		}
	}

	@Override
	public void create(Person p) //Write to XML 
	{
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("person");
			doc.appendChild(rootElement);

			// id element
			Element id = doc.createElement("Id");
			id.appendChild(doc.createTextNode(""+ p.id));
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
			Element age = doc.createElement("Age");
			age.appendChild(doc.createTextNode(""+ p.age));
			rootElement.appendChild(age);

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

	@Override
	public ArrayList<Person> read() //Read from XML 

	{
		ArrayList<Person> ar = new ArrayList<Person>();

		File xmlFile = new File("C:\\person.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=null;
		Document doc=null;
		try 
		{
			dBuilder = dbFactory.newDocumentBuilder();
		} 
		catch (ParserConfigurationException e1) 
		{
			e1.printStackTrace();
		}
		try 
		{
			doc = dBuilder.parse(xmlFile);
		}
		catch (SAXException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

		int id, age;
		String fname, lname;

	//	NodeList list2 =  doc.getChildNodes();
		NodeList list = doc.getElementsByTagName("person");

		System.out.println(list.getLength());

		for (int i=0; i<list.getLength(); i++)
		{
			Node node = list.item (i);
			if (node.getNodeType()== Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				id = Integer.parseInt(element.getElementsByTagName("Id").item(0).getTextContent());
				fname = element.getElementsByTagName("FName").item(0).getTextContent();
				lname = element.getElementsByTagName("LName").item(0).getTextContent();
				age = Integer.parseInt(element.getElementsByTagName("Age").item(0).getTextContent());
				ar.add( new Person(id, fname, lname, age));
			}
		}
		System.out.println("info from XML read successfully");
		return ar;
	}

	@Override
	public void update(Person p) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Person p) 
	{
		// TODO Auto-generated method stub
	}
}
