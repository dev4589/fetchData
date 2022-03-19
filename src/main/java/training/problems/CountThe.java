package training.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CountThe {

	public static final String PATH = "src/main/java/training/problems/problem_input/2/";
	public static final long START_T = System.nanoTime();
	public static final String REGEX= "^[Tt]he\\s*\\W";
	public static Pattern PATTERN;
	public static void main(String args[]) throws IOException, InterruptedException {
		int count = 0;
		PATTERN=Pattern.compile(REGEX);
		
		List<String> results = new ArrayList<String>();
		File[] files = new File(PATH).listFiles();
		for (File file : files)
			if (file.isFile())
				results.add(file.getName());
		for (File file : files) {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "";

			while ((line = reader.readLine()) != null) {
				if (PATTERN.matcher(line).find())
					count++;
			}
			reader.close();
		}
		final long end_T = System.nanoTime();
		System.out.println("Occurance of 'The' in all files are " + count);
		System.out.println("Process time in millisecond " + (end_T - START_T));

	}
}