package countModifierRelatedData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCSV
{
	static String	inputFile	= "/home/devanshparmar/Documents/CHS-1902-Regional Employee Assistance Program-REAP-1902-2022-07-01-2022-07-27.tsv";
	static Pattern	pattern		= Pattern.compile("\\,\\s[A-Z0-9]{2}\\-");

	public static void main(String args[]) throws IOException
	{

		BufferedReader buffRead = new BufferedReader(new FileReader(inputFile));
		String line = null;
		List<String> allLines = new ArrayList<>();
		while ((line = buffRead.readLine()) != null)
		{
			allLines.add(line);
		}
		int visitIndex = 0;
		int payorIndex = 0;
		int modifierIndex = 0;

		List<ModifierCount> modyList = new ArrayList<>();

		String[] firstLineSplit = allLines.get(0).split("\\t");

		for (int index = 0; index < firstLineSplit.length; index++)
		{
			if (firstLineSplit[index].equals("visitType") && visitIndex == 0)
			{
				visitIndex = index;
			}
			if (firstLineSplit[index].equals("payor") && payorIndex == 0)
			{
				payorIndex = index;
			}
			if (firstLineSplit[index].equals("EANDM_Final") && modifierIndex == 0)
			{
				modifierIndex = index;
			}
		}

		for (int index = 1; index < allLines.size(); index++)
		{
			String[] sections = allLines.get(index).split("\\t");

			if (sections[modifierIndex].contains("="))
			{
				String[] modifier = sections[modifierIndex].split("[\\[\\]]+", sections[modifierIndex].length() - 1);

				if (modifier[1].matches(".*(\\s[A-Z0-9]{2}\\-).*"))
				{
					List<Integer> splitPos = new ArrayList<>();
					Matcher matcher = pattern.matcher(modifier[1]);
					while (matcher.find())
					{
						splitPos.add(matcher.start());
					}
					List<String> createList = new ParseCSV().fillSeparateModList(splitPos, modifier[1]);
					for (String mod : createList)
					{
						modyList.add(new ModifierCount(sections[visitIndex], sections[payorIndex], mod));
					}
				}
				else
				{
					modyList.add(new ModifierCount(sections[visitIndex], sections[payorIndex], modifier[1]));
				}

			}
		}

	}

	private List<String> fillSeparateModList(List<Integer> splitPos, String modifier)
	{
		int begin = 0;
		int end = 0;
		List<String> modList = new ArrayList<>();

		for (int index = 0; index < splitPos.size(); index++)
		{
			end = splitPos.get(index);
			String eachMod = modifier.substring(begin, end);
			modList.add(cleanSen(eachMod));
			begin = end;
		}
		modList.add(cleanSen(modifier.substring(end)));

		return modList;
	}

	private String cleanSen(String sen)
	{
		if (sen.startsWith(","))
		{
			return sen.substring(1).trim();
		}
		return sen;
	}
}

class ModifierCount
{
	private String	visitType;
	private String	payortype;
	private String	modifierType;

	public ModifierCount(String visitType, String payorType, String modifierType)
	{
		this.visitType = visitType;
		this.payortype = payorType;
		this.modifierType = modifierType;
	}

	public String getVisitType()
	{
		return visitType;
	}

	public void setVisitType(String visitType)
	{
		this.visitType = visitType;
	}

	public String getPayortype()
	{
		return payortype;
	}

	public void setPayortype(String payortype)
	{
		this.payortype = payortype;
	}

	public String getModifierType()
	{
		return modifierType;
	}

	public void setModifierType(String modifierType)
	{
		this.modifierType = modifierType;
	}

}
