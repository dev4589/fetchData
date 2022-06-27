package training.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindBMIValue {
	
	public static final String PATH = "src/main/java/training/problems/problem_input/11/";
	
	public static void main(String[] args) throws IOException {
		
		FileReader file = new FileReader(PATH + "TextDocument");
		BufferedReader buffRead = new BufferedReader(file);

		String pat= "(BMI|[bB]ody mass index)([^\\d]*)(\\d[\\d.]+)";
		Pattern pattern = Pattern.compile(pat);
		String str = "";
		
		while ((str = buffRead.readLine()) != null) {
			Matcher matcher = pattern.matcher(str);
			if (matcher.find()) {
				System.out.println(matcher.group(3));
			}
		}
	}

}