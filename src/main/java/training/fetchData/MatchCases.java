package training.fetchData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchCases
{

	public static void main(String[] args)
	{
		Pattern pat = Pattern.compile("COMPLETED", Pattern.CASE_INSENSITIVE);
		Matcher match = pat.matcher("B-TYPE NATRIURETIC PEPTIDE STAT CHEMISTRY COMPLETED COMPREHENSIVE METABOLIC PANEL STAT CHEMISTRY 08/04/22 04:05 COMPLETED\"");
		
		if (match.find())
		{
			System.out.println(match.group(0));
		}
	}
}

//public class MatchCases
//{
//	public static void main(String[] args)
//	{
//		Pattern pattern = Pattern.compile("COMPLETED");
//		Matcher matcher = pattern.matcher("B-TYPE NATRIURETIC PEPTIDE STAT CHEMISTRY COMPLETED COMPREHENSIVE METABOLIC PANEL STAT CHEMISTRY 08/04/22 04:05 COMPLETED");
//		boolean matchFound = matcher.find();
//		if (matchFound)
//		{
//			System.out.println("Match found");
//		}
//		else
//		{
//			System.out.println("Match not found");
//		}
//	}
//}
