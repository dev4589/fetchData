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
	public static final long startT = System.currentTimeMillis();

	public static void main(String args[]) throws IOException, InterruptedException {
		int count = 0;
		List<String> results = new ArrayList<String>();
		File[] files = new File(PATH).listFiles();
		for (File file : files)
			if (file.isFile())
				results.add(file.getName());
		for (File file : files) {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			String line = "";

			while ((line = reader.readLine()) != null) {
				if (Pattern.compile("^The ").matcher(line).find())
					count++;
			}
		}
		final long endT = System.currentTimeMillis();
		System.out.println("Occurance of 'The' in all files are " + count);
		System.out.println("Process time in millisecond " + (endT - startT));

	}
}