package training.problems;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ExampleSet {
	public static void main(String args[]) {
		TreeSet<Integer> set=new TreeSet<Integer>();
		int num[]= {9,6,3,1,2,5,8,6};
		for(int i:num) {
			set.add(i);
			System.out.println(set);
		}
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			Integer in=it.next();
			System.out.print(in+"\t");
		}
		
		Set<Integer> set2=new TreeSet<Integer>();
		for(int i:num)
			set2.add(i);
		SortedSet <Integer> sort=(SortedSet <Integer>) set2;
		it=sort.iterator();
		System.out.println();
		while(it.hasNext()) {
			Integer in=it.next();
			System.out.print(in+"\t");
		}
		
		String ch[]= {"i","a","g","f"};
		SortedSet<String> tree=new TreeSet<String>();
		System.out.println();
		for(String s:ch) {
			tree.add(s);
			System.out.println(tree);
		}
		
	}
}
