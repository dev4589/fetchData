package training.problems;

/*
	Question 8 : Convert tabular format to index file format (use readme for more detail)
*/
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class tabularToIndex {
	private static void tableToIndex (String cur_file) throws IOException {
		String line;
		FileReader file = new FileReader (cur_file);
		BufferedReader b_read = new BufferedReader (file);

		lHMExtended top_root = new lHMExtended();
		
		while ((line = b_read.readLine()) != null) {
		
			lHMExtended node1 = top_root;
			
			String[] values = line.split("\\t");
			
			for (int i = 1; i < values.length - 1; i++) {
			
				lHMExtended child_node = (lHMExtended) node1.get(values[i]);
				
				if (child_node == null)
				
					node1.put (values[i], child_node = new lHMExtended());
				
				node1 = child_node;
			}
			//Adding Code to the End
			
			lHMExtended child_node = (lHMExtended) node1.get(values[values.length - 1] + " ~ " + values[0]);
			
			if (child_node == null)
			
				node1.put (values[values.length - 1] + " ~ " + values[0], child_node = new lHMExtended());

			node1 = child_node;
		}

		b_read.close();
		
		display (top_root, "", "\t");
	}

	private static void display(lHMExtended node, String indentation, String indentation_to_add) {
		String key = "";
		String str = "";
		ArrayList<String> lines = new ArrayList<String>();

		for (Entry<String, lHMExtended> entry : node.entrySet()) {
			if (entry.getKey().contains("~")) {
				String[] token = entry.getKey().split(" ~ ");
				if (!token[0].equals(key)) {
					key = token[0];
					str = entry.getKey();
				} else {
					str = str + "," + token[1];
				}
			} else {
				System.out.println(indentation + entry.getKey());
			}
			display (entry.getValue(), indentation + indentation_to_add, indentation_to_add);
		}
		String line = indentation + str;
		if (!line.trim().isEmpty()) {
			lines.add (line);
			System.out.println(line);
		}
	}

	static class lHMExtended extends LinkedHashMap<String, lHMExtended> {
	}

	// main method
	public static void main(String[] args) throws IOException {
		String file_path = "src/main/java/training/problems/problem_input/8/InputFile";

		tableToIndex (file_path);
	}
}
