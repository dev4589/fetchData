package training.problems;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteFiles {

	public static final String PATH = "src/main/java/training/problems/problem_input/1/";

	public static void main(String args[]) 
	{
		Process proc;
		try {
			proc = Runtime.getRuntime().exec("cat " + PATH + "DeleteFiles.txt");

			BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null) {

				Process proc2 = Runtime.getRuntime().exec("find . -name " + line);
				BufferedReader reader2 = new BufferedReader(new InputStreamReader(proc2.getInputStream()));
				String delete = reader2.readLine();

				try {
					File file = new File(delete);

					if (file.delete())
						System.out.println("File " + delete + " Deleted");
					else
						System.out.println("Operation failed");
				} catch (NullPointerException nl) {
					System.out.println("Files do not exist");
					break;
				}
			}
			proc.waitFor();

		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException error");
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("InturruptedException error");
		}

	}
}