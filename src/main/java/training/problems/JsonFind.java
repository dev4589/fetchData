package training.problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFind {
	public static final String PATH = "src/main/java/training/problems/problem_input/3/AmazonMed_Json/";
	public static final long START_T = System.currentTimeMillis();

	public static void main(String[] args)
			throws IOException, JsonParseException, JsonMappingException, FileNotFoundException {

		ObjectMapper jsonMap = new ObjectMapper();
		File[] files = new File(PATH).listFiles();
		Double score = null;

		for (File file : files) {
			if (file.length() == 0) {
				System.out.println("\nFile: " + file.getName() + " is empty.");
				continue;
			}
			int count = 0;
			try {
				Map<String, Object> entityObj = jsonMap.readValue(file, new TypeReference<Map<String, Object>>() {
				});

				@SuppressWarnings("unchecked")
				List<Object> entityArray = (List<Object>) entityObj.get("Entities");

				System.out.println("\nFrom file: " + file.getName());
				for (int i = 0; i < entityArray.size(); i++) {

					@SuppressWarnings("unchecked")
					Map<String, Object> scoreObj = (Map<String, Object>) entityArray.get(i);
					score = (Double) scoreObj.get("Score");
					if (score == null)
						continue;
					if (score < 0.90) {
						count++;
						System.out.println("Text: " + scoreObj.get("Text"));
					}
				}
			} 
			finally {
				if (count == 0)
					System.out.println("File didn't have any Score which is lesser than 90%");
//				else
//					System.out.println("this is count "+count);
			}
		}

		final long end_T = System.currentTimeMillis();
		System.out.println("Process time in millisecond " + (end_T - START_T));

	}
}
