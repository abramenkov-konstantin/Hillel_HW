package person.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;



import person.dal.Person;

public class FromXML implements ActionListener 
{

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		File xmlFile = new File("C:\\person.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			System.out.println("ok1");
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc=null;
		try {
			doc = dBuilder.parse(xmlFile);
			System.out.println("ok2");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NodeList list = doc.getElementsByTagName("person");
		ArrayList<Person> arXML = new ArrayList<Person>();

		int id, age;
		String fname, lname;

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

				arXML.add( new Person(id, fname, lname, age));
			}
		}
		for (Person p : arXML) 
		{
			System.out.println(p);
		}
		System.out.println("info read from XML");
	}

	// TODO Auto-generated method stub

}
