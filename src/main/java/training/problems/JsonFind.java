package training.problems;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFind {
	public static final String PATH = "src/main/java/training/problems/problem_input/3/AmazonMed_Json/";
	public static final long START_T = System.currentTimeMillis();

	public static void main(String[] args) throws IOException, ParseException, FileNotFoundException {

		JSONParser jparse = new JSONParser();
		
		List<String> results = new ArrayList<String>();
		File[] files = new File(PATH).listFiles();
		for (File file : files)
			if (file.isFile())
				results.add(file.getName());

		for (File file : files) {
			if (file.length() == 0) {
				System.out.println("\nFile: " + file.getName() + " is empty.");
				continue;
			}

			FileReader reader = new FileReader(file.getPath());
			JSONObject entityObj = (JSONObject) jparse.parse(reader);

			JSONArray entityArray = (JSONArray) entityObj.get("Entities");

			System.out.println("\nFrom file: " + file.getName());
			for (int i = 0; i < entityArray.size(); i++) {
				
				JSONObject scoreObj = (JSONObject) entityArray.get(i);
				Double score = (Double) scoreObj.get("Score");
				if (score < 0.90)
					System.out.println("Text: " + scoreObj.get("Text"));
			}
		}

		final long end_T = System.currentTimeMillis();
		System.out.println("Process time in millisecond " + (end_T - START_T));
		
	}
}
