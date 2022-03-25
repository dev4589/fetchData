package training.problems;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;

import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
class CollectionDemo {

	public static void main(String[] args) {

		ArrayList<Object> obj = new ArrayList<Object>();
		obj.add(null);
		obj.add(1);
		obj.add('e');
		@SuppressWarnings("unused")
		List<Integer> list=new ArrayList<Integer>();
//		Queue que;
		
		Deque<Integer> link=new LinkedList<Integer>();
		link.add(4);
//		Deque deq;
		
		obj.add(link);
		System.out.println(obj.get(3) instanceof LinkedList);
		
		

		Map<Object,Object> hm=new HashMap<Object,Object>();
		hm.put("age",new Double(25));
		hm.put("age",new String("hello"));
		hm.put("age2",new Double(25));
		System.out.println(hm.keySet());
		System.out.println(hm.entrySet());
		System.out.println(hm);
		System.out.println(hm.values());
		CollectionDemo demo=new CollectionDemo();
		demo.print((HashMap<Object,Object>)hm);
		
		
		Map<String,Object> tree=new TreeMap<String,Object>();
		tree.put("age", 25);
		tree.put("age2", 20);
		
		demo.printTree((TreeMap<String, Object>) tree);
		
		Map<Integer,Integer> notAlreadySorted=new TreeMap<Integer,Integer>();
		notAlreadySorted.put(1, 55);
		System.out.println(notAlreadySorted);
		notAlreadySorted.put(-5, 45);
		System.out.println(notAlreadySorted);
		notAlreadySorted.put(5, 198);
		System.out.println(notAlreadySorted);
		SortedMap<Integer,Integer> sorted=(SortedMap<Integer, Integer>) notAlreadySorted;
		
		System.out.println(notAlreadySorted instanceof SortedMap);
		System.out.println(sorted.firstKey());
	}
	
	void print(HashMap<Object,Object> map) {
		map.put(null, 56);
		map.put(24, 24);
		Set<Entry<Object, Object>> set=map.entrySet();
		
		Iterator<Entry<Object, Object>> i=set.iterator();
		System.out.println("Set\n");
		while(i.hasNext()) {
			Map.Entry<Object, Object> me=(Map.Entry<Object, Object>)i.next();
			System.out.println(me+"\n");
		}
		
		System.out.println(map);
	}
	void printTree(Map<String,Object> map) {
		map.put("name", "Devansh");
		map.put("company", "agshealth");
		System.out.println(map);
	}
}