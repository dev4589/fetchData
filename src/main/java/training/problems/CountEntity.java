package training.problems;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

public class CountEntity {
	public static final String PATH = "src/main/java/training/problems/problem_input/6/";

	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		CountEntity cn = new CountEntity();
		
		File[] files = new File(PATH).listFiles();
		for (File file : files) {
	
			Map<String, Integer> distinctEntity = new HashMap<>(10);

			Document doc = db.parse(file);
			NodeList nodes = doc.getElementsByTagName("RelationSet");
			DocumentTraversal docParse = (DocumentTraversal) doc;
			
			for (int i = 0; i < nodes.getLength(); i++) {
				NodeIterator iter = docParse.createNodeIterator(nodes.item(i), NodeFilter.SHOW_ELEMENT, null, true);
				cn.fetchNodes(distinctEntity, iter);
			}
			
			System.out.println("\nFrom file : "+file.getName());
			cn.printEntityCount(distinctEntity);
			
		}
	}


	void fetchNodes(Map<String, Integer> distinctEntity, NodeIterator it) {
		CountEntity cn = new CountEntity();
		
		for (Node node = it.nextNode(); node != null; node = it.nextNode()) {
			cn.entityCount(distinctEntity, node.getNodeName());
		}
	}

	void entityCount(Map<String, Integer> distinctEntity, String name) {

		if (distinctEntity.containsKey(name)) {
			Integer count = distinctEntity.get(name);
			distinctEntity.put(name, ++count);
		}
		else {
			distinctEntity.put(name, 1);
		}
	}

	void printEntityCount(Map<String, Integer> distinctEntity) {
		for (String s : distinctEntity.keySet())
			System.out.println("Count of " + s + " : " + distinctEntity.get(s));
	}
	
}
