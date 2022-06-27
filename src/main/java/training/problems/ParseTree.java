package training.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParseTree {

	public static final String PATH = "src/main/java/training/problems/problem_input/7/";
	static List<String> strList = new ArrayList<>();
	static List<Integer> countList = new ArrayList<>();
	static List<String> storeList = new ArrayList<>();

	public static void main(String args[]) throws IOException {

		FileReader file = new FileReader(PATH + "InputFile");
		BufferedReader buff = new BufferedReader(file);

		String[] str = {};
		try {
			int countOfString = 0;
			while ((str = buff.readLine().split("@", 2)) != null) {
				countOfString = countTabs(str[0], 0);
				strList.add(str[0].trim());
				countList.add(countOfString);
			}

		} catch (NullPointerException e) {
			System.out.println("File ended.");
		}

		handleData();
		writeInFile();

		buff.close();
	}

	static int countTabs(String str, int tabs) {
		if (str.matches("^\\t.*")) {
			tabs = countTabs(str.substring(1), ++tabs);
		}
		return tabs;
	}

	static void handleData() {

		for (int i = 0; i < strList.size(); i++) {
			if (strList.get(i).contains("~")) {
				String[] str = strList.get(i).split("~");
				fetchPrevious(i, str);
			}
		}
	}

	static void fetchPrevious(int index, String[] str) {
		List<String> prevNodes = new ArrayList<>();
		int forLoop = countList.get(index);
		for (int i = index; i >= 0; i--) {
			if (countList.get(i) == (forLoop) - 1) {
				prevNodes.add(strList.get(i));
				forLoop--;
			}
		}
		printFormat(prevNodes, str);
	}

	static void printFormat(List<String> prevNodes, String str[]) {
		Collections.reverse(prevNodes);

		if (str[1].contains(",")) {
			String trimForCode[] = str[1].split(",");
			for (String code : trimForCode) {
				String store = "";
				store += code.trim() + "\t";
				for (String s : prevNodes) {
					if (s.contains("~")) {
						String[] trimFromCode = s.split("~");
						store += trimFromCode[0].trim() + "\t";
					} else {
						store += s.trim() + "\t";
					}
				}
				store += str[0].trim();
				storeList.add(store);
			}
		} else {
			String store = "";
			store += str[1].trim() + "\t";
			for (String s : prevNodes) {
				if (s.contains("~")) {
					String[] trimFromCode = s.split("~");
					store += trimFromCode[0].trim() + "\t";
				} else {
					store += s.trim() + "\t";
				}
			}
			store += str[0].trim();
			storeList.add(store);
		}
	}

	static void writeInFile() throws IOException {
		FileWriter writeFile = new FileWriter(PATH + "Output", true);
		for (String s : storeList)
			writeFile.append(s + "\n");
		writeFile.close();
	}
}
