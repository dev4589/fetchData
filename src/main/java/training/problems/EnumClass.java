package training.problems;

import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Vector;

public class EnumClass {

	public static void main(String args[]) {
		Enumeration<String> days;
		Vector<String> dayNames = new Vector<String>();

		dayNames.add("Sunday");
		dayNames.add("Monday");
		dayNames.add("Tuesday");
		dayNames.add("Wednesday");
		dayNames.add("Thursday");
		dayNames.add("Friday");
		dayNames.add("Saturday");
		days = dayNames.elements();

		while (days.hasMoreElements()) {
			System.out.println(days.nextElement());
		}
		
		LinkedHashSet<String> hs = new LinkedHashSet<>();
		hs.add("B");
		hs.add("A");
		hs.add("D");
		hs.add("E");
		hs.add("C");
		hs.add("F");
		System.out.println(hs);
		
	}
}
