package training.excercise;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class TestParser {

	private static String readFile(String filePath) throws IOException {
		return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filePath)),
				java.nio.charset.StandardCharsets.UTF_8);
	}
	
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
		// TODO Auto-generated method stub
		String pcsFolder = "/home/devanshparmar/devansh/CHS/1902/PCS/";

		String fileName = "39696714.xml";
		String pcsData=readFile(pcsFolder + fileName);

//		System.out.println(pcsData);
		DocumentBuilder	documentBuilder		= null;
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setIgnoringElementContentWhitespace(false);
		documentBuilderFactory.setIgnoringComments(false);
		documentBuilderFactory.setCoalescing(false);
		documentBuilderFactory.setExpandEntityReferences(true);
		documentBuilder = documentBuilderFactory.newDocumentBuilder();

		
		
		Document document = documentBuilder.parse(new InputSource(new StringReader(pcsData)));
		document.getDocumentElement().normalize();
		Element documentElement = document.getDocumentElement();
		
		for (Node node = documentElement.getFirstChild(); node != null; node = node.getNextSibling())
		{
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element nodeElement = (Element) node;
	System.out.println(nodeElement.getAttribute("value"));
//				parseSectionElement(nodeElement);
			}
		}
	}
	
}
