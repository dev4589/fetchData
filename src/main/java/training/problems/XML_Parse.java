package training.problems;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XML_Parse {

	public static final String PATH = "src/main/java/training/problems/problem_input/5/";
	static TreeMap<String, Integer> mapValueRank = new TreeMap<String, Integer>();

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		XML_Parse xml = new XML_Parse();
		dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		File[] files = new File(PATH).listFiles();
		for (File file : files) {
			Document docMain = db.parse(file);

			System.out.println("\n\nFrom File " + file.getName());
			System.out.println("Root Node : " + docMain.getDocumentElement().getNodeName());
			System.out.println("------");

			NodeList list_Icd10CmCode = docMain.getElementsByTagName("Icd10CmCode");
			for (int i = 0; i < list_Icd10CmCode.getLength(); i++) {
				if (list_Icd10CmCode != null) {
					xml.printNode(list_Icd10CmCode.item(i).getChildNodes());
				}
			}
		}
	}

	void printNode(NodeList nodeList) {

		XML_Parse xml = new XML_Parse();
		List<String> countValue = new ArrayList<>();
		TreeMap<String, Integer> mapValueRank = new TreeMap<>();

		for (int count = 0; count < nodeList.getLength(); count++) {
			xml.tempNodeParse(nodeList.item(count));
		}
		countValue.add(mapValueRank.firstKey());
		System.out.println(countValue.get(0));
	}

	void tempNodeParse(Node tempNode) {
		XML_Parse xml = new XML_Parse();
		if (tempNode.getNodeType() == Node.ELEMENT_NODE && tempNode.getNodeName() == "code"
				&& tempNode.hasAttributes()) {
			xml.parseElement((Element) tempNode);
		}
	}

	void parseElement(Element ele) {
		XML_Parse xml = new XML_Parse();
		
		if (mapValueRank.isEmpty()) {
			mapValueRank.put(ele.getAttribute("value"), Integer.valueOf(ele.getAttribute("rank")));
		} else {
			xml.checkAndAssign(mapValueRank.firstKey(), ele);
		}

	}

	void checkAndAssign(String valueKey, Element ele) {
		if (!valueKey.isEmpty()) {
			Integer check = Integer.valueOf(mapValueRank.get(valueKey));
			if (check < Integer.valueOf(ele.getAttribute("rank"))) {
				mapValueRank.clear();
				mapValueRank.put(ele.getAttribute("value"), Integer.valueOf(ele.getAttribute("rank")));
			}
		}
	}

}