package training.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles_CSV_TSV_TXT {
	public static final String PATH = "src/main/java/training/problems/problem_input/4/";

	public static void main(String args[]) throws IOException {
		// this will list out all files with their extension
		File[] files = new File(PATH).listFiles();
		for (File file : files) {

			BufferedReader buffReader = new BufferedReader(new FileReader(file));

			// finds the index of amount
			String line = buffReader.readLine();
			List<Integer> index = new ArrayList<>(); // index of amount
			String[] splittedLine = line.split("[\\t,;:|]");
			for (int i = 0; i < splittedLine.length; i++)
				if (splittedLine[i].matches("[aA]mount.*"))
					index.add(i);

			// Add amount values in list

			List<List<Double>> amounts = new ArrayList<List<Double>>();
			while ((line = buffReader.readLine()) != null) {
				splittedLine = line.split("[\\t,;:|]");
				List<Double> amount = new ArrayList<Double>();

				for (Integer i : index)
					amount.add(Double.valueOf(splittedLine[i]));
				amounts.add(amount);
			}
			List<Double> sums = new ArrayList<>(3);
			// intialize arrayList
			for (@SuppressWarnings("unused") Integer i : index)
				sums.add((double) 0);

			for (int i = 0; i < amounts.size(); i++) {
				List<Double> amount = new ArrayList<>();
				amount = amounts.get(i);
				for (int j = 0; j < amount.size(); j++) {
					Double sum = sums.get(j);
					sum += amount.get(j);
					sums.set(j, sum);
				}
			}
			for (int i = 0; i < sums.size(); i++)
				System.out.println(file.getName() + " Amount sum: " + sums.get(i));
//			System.out.println(index);
//			System.out.println(sums);

			buffReader.close();
		}
	}
}