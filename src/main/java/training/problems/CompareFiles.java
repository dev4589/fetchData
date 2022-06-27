package training.problems;

import java.io.*;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class CompareFiles {

	public static final String PATH1 = "src/main/java/training/problems/problem_input/9/CM1/";
	public static final String PATH2 = "src/main/java/training/problems/problem_input/9/CM2/";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		File[] fileList1 = new File(PATH1).listFiles();
		File[] fileList2 = new File(PATH2).listFiles();

		Set<String> fileSet1 = new HashSet<>();
		for (File f : fileList1)
			fileSet1.add(f.getName());

		Set<String> fileSet2 = new HashSet<>();
		for (File f : fileList2)
			fileSet2.add(f.getName());

		Set<String> commonFiles = new HashSet<>(fileSet1);
		commonFiles.retainAll(fileSet2);

		Iterator itFile = commonFiles.iterator();
		while (itFile.hasNext()) {
			String fileName=(String) itFile.next();
			System.out.println("\n\n"+fileName+"\n\n");

			File file1 = new File(PATH1 + fileName);
			File file2 = new File(PATH2 + fileName);

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();

			Set<String> set1 = new HashSet<>();
			Set<String> set2 = new HashSet<>();

			set1 = allTheDoubleProcess(db, file1);
			set2 = allTheDoubleProcess(db, file2);

			compareSet(set1, set2);
		}
	}

	static Set<String> allTheDoubleProcess(DocumentBuilder db, File file) throws SAXException, IOException {
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		NodeList nodes = doc.getElementsByTagName("code");
		Set<String> set = new HashSet<>();

		for (int i = 0; i < nodes.getLength(); i++) {
			Element ele = (Element) nodes.item(i);
			set.add(ele.getAttribute("value"));
		}
		return set;
	}

	static void compareSet(Set<String> set1, Set<String> set2) {
		Set<String> matchCases = new HashSet<>(set1);
		matchCases.retainAll(set2); // intersection

		Set<String> missCases = new HashSet<>(set1);
		missCases.removeAll(set2); // what is in a and not b

		Set<String> extraCases = new HashSet<>(set2);
		extraCases.removeAll(set1); // what is in b and not a

		printOutputSets(set1, set2, matchCases, missCases, extraCases);

	}

	static void printOutputSets(Set<String> set1, Set<String> set2, Set<String> matchCases, Set<String> missCases,
			Set<String> extraCases) {

		System.out.println("Total cases in file 1: "+set1.size()+" --> "+set1);
		System.out.println("Match cases: "+matchCases.size()+" --> "+matchCases);
		System.out.println("Missed cases: "+missCases.size()+" --> "+missCases);
		System.out.println("Extra cases: "+extraCases.size()+" --> "+extraCases);
	}

}
