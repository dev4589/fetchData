package training.problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MatchConflicts {

	public static final String PATH = "src/main/java/training/problems/problem_input/12/";

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader(PATH + "Inputfile");
		BufferedReader buff = new BufferedReader(file);

		List<Record> rec = new ArrayList<>();

		Set<String> stringSet = new HashSet<>();
		String str = "";

		while ((str = buff.readLine()) != null) {
			stringSet.add(str.toLowerCase());
		}

		stringSet = new TreeSet<>(stringSet);
		Iterator<String> it = stringSet.iterator();

		while (it.hasNext()) {
			String s[] = it.next().split("\\t");
			List<String> ans = new ArrayList<>();
			ans.add(s[1]);
			ans.add(s[2]);
			rec.add(new Record(s[0], ans));
		}
		List<Record> conflict = new ArrayList<>();
		List<Record> unique = new ArrayList<>();
		try {
			for (int i = 0; i < rec.size() - 1; i++) {

				if (rec.get(i).getTitle().equals(rec.get(i + 1).getTitle())) {
					conflict.add(rec.get(i));
				}

				else if (checkConflict(conflict, rec.get(i))) {
					conflict.add(rec.get(i));
				}

				else {
					unique.add(rec.get(i));
				}

			}
		} finally {

			int i = rec.size() - 1;
			if (checkConflict(conflict, rec.get(i))) {
				conflict.add(rec.get(i));
			} else {
				unique.add(rec.get(i));
			}

		}

		printConflict(conflict, unique);

		buff.close();
	}

	static boolean checkConflict(List<Record> conflict, Record rec) {
		for (Record con : conflict) {
			if (rec.getTitle().equals(con.getTitle())) {
				return true;
			}
		}
		return false;
	}

	static void printConflict(List<Record> conflict, List<Record> unique) {
		System.out.println("-----------------------------------------------------");
		System.out.println("Conflict List\n");
		for (int i = 0; i < conflict.size(); i++)
			System.out.println(conflict.get(i).getTitle() + " " + conflict.get(i).getAns().get(0) + " "
					+ conflict.get(i).getAns().get(1));

		System.out.println("\n\n\n\n\n\n-----------------------------------------------------");
		System.out.println("Unique List\n");
		for (int i = 0; i < unique.size(); i++)
			System.out.println(unique.get(i).getTitle() + " " + unique.get(i).getAns().get(0) + " "
					+ unique.get(i).getAns().get(1));

	}

}

class Record {
	private String title;
	private List<String> ans = new ArrayList<>(2);

	Record(String title, List<String> ans) {
		this.setTitle(title);
		this.setAns(ans);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getAns() {
		return ans;
	}

	public void setAns(List<String> ans) {
		this.ans = ans;
	}

	public boolean checkSameObject(Record r) {
		if (r == null)
			return false;
		return this.getTitle().equals(r.getTitle()) && this.getAns().equals(r.getAns());
	}
}