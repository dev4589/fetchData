package s3Download;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MatchAllFiles
{

	public static void main(String[] args) throws IOException
	{
		List<String> list = new MatchAllFiles().getfacilities();
		for (String code : list)
		{
			String folder = "/home/devanshparmar/devansh/SCP/HF/" + code + "/text_output_new_change/";

			for (File requestFolder : new File(folder).listFiles())
			{
				String inputFilePath = null;
				String outputFilePath = null;
				String currentPath = requestFolder.getAbsolutePath();
				if (currentPath.endsWith(".txt"))
				{
					inputFilePath = currentPath;
				}

				if (inputFilePath == null)
				{
					continue;
				}

				List<String> allLines = new ArrayList<>();
				allLines.add(requestFolder.getName());
				allLines.addAll(Files.readAllLines(Paths.get(inputFilePath)));
				new MatchAllFiles().writeFile(allLines);
			}
		}
	}

	private List<String> getfacilities() throws IOException
	{
		String path = "/home/devanshparmar/git/fetchData/src/main/java/s3Download/facilityId";
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;

		List<String> facilities = new ArrayList<>();
		while ((line = br.readLine()) != null)
		{
			facilities.add(line);
		}
		br.close();

		return facilities;
	}

	private void writeFile(List<String> outputResult) throws IOException
	{
		FileWriter fw = new FileWriter("/home/devanshparmar/devansh/SCP/HF/inputFilesChange", true);
		for (String line : outputResult)
		{
			fw.write(line);
			fw.write("\n");
		}
		fw.close();
	}
}
