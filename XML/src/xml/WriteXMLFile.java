package xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class WriteXMLFile {

	public static void main(String argv[]) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();

			// root element
			Element rootElement = doc.createElement("person");
			doc.appendChild(rootElement);

			// id element
			Element id = doc.createElement("id");
			id.appendChild(doc.createTextNode("1"));
			rootElement.appendChild(id);

			// vname element
			Element vname = doc.createElement("vname");
			vname.appendChild(doc.createTextNode("Vasya"));
			rootElement.appendChild(vname);

			// Fname element
			Element fname = doc.createElement("Fname");
			fname.appendChild(doc.createTextNode("Pupkin"));
			rootElement.appendChild(fname);

			// Age element
			Element age = doc.createElement("Age");
			age.appendChild(doc.createTextNode("25"));
			rootElement.appendChild(age);


			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("C:\\person.xml"));
			transformer.transform(source, result);

			// Output to console for testing
			StreamResult consoleResult =
					new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
