package training.collections;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListOrArray {
	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(null);
		list.add(0, 1);
//		for (Integer i : list)
//			System.out.println(i instanceof Integer);

		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> newL = (List<Integer>) list;

		ArrayList<Serializable> lisb = new ArrayList<Serializable>();
		lisb.add(null);
		lisb.add(0);
		lisb.add('a');
		lisb.add("abc");
		
		
//		System.out.println(lisb.get(2));
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		lisb.add(arr);

//		for (Object c : lisb) {
//			if (c instanceof Integer[])
//				for (Character p : List.of((Character) c))
//					System.out.println(p);
//			System.out.println(c);
//		}
		ArrayList<Integer> arrBig=new ArrayList<Integer>();
		arrBig.add(55);
		arrBig.add(61);
		arrBig.add(8);
		arrBig.add(14);
		arrBig.addAll(arr);
	
		for(int i=0;i<arrBig.size();i++) {
			for(int j=0;j<arrBig.get(4);j++) {
				System.out.println(arrBig.get(i));
			}
		}

//		List<?> th4 = (ArrayList<?>) lisb.get(4);
//		for (Object a : th4)
//			System.out.println(a);
		
		
		
	}
}
