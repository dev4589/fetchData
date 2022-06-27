package training.problems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {

	public static final String PATH = "src/main/java/training/problems/problem_input/7/";

	public static void main(String[] args) {
		
		FileWriter writeFile = null;
		try {
			writeFile = new FileWriter(PATH+"Output",true);
			writeFile.append("hello\n");
			
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
