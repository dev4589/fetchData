package training.excercise;

import java.util.*;

public class ExMap {

	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
//		System.out.println(list.isEmpty());
//		
//		List<Integer> listClone;
//		listClone=(List<Integer>) list.clone();
//		ChangeList.changeInList(listClone);
//		System.out.println(list.isEmpty());
//		System.out.println(listClone.isEmpty());

		List<String> mutableList = new ArrayList<>();
		List<String> mutableList1 = new LinkedList<>();
		List<String> unmodifiable = Collections.unmodifiableList(mutableList);

		mutableList.add("hello");
		System.out.println(unmodifiable);
//		int a = 10;
		int[] arr = { 1, 2, 4 };
		List<int[]> fromArr;
		fromArr = Arrays.asList(arr);
		System.out.println(fromArr);

		System.out.println(arr.getClass());
		ChangeList li = new ChangeList();
		System.out.println(fromArr.getClass());

		IntCheck i = new IntCheck();
		Integer a = new Integer(10);
		Integer b = new Integer(a);
		System.out.println(a == b);

		int[] arr2 = arr;

		arr2[0] = 6;
		System.out.println(arr == arr2);
		for (int index = 0; index < arr.length; index++)
			System.out.println(arr[index]);

		i.checkNow(arr);

		for (int index = 0; index < arr.length; index++)
			System.out.println(arr[index]);

		Integer ba = a;

		System.out.println("\n\n" + a);
		checkNow(a);
		System.out.println(a);

		checkType((ArrayList<String>) mutableList);
		try {
			checkType((ArrayList<String>) mutableList1);
		} catch (Exception e) {
			System.out.println("can't be done");
		}

		checkFor();
		String split="hello";
		System.out.println(split.split(";")[0]);
		
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(2);
		
		Map<String, List<Integer>> map=new HashMap<>();
		map.put("first", list);
		
		System.out.println(map.get("first"));
		list.add(3);
		System.out.println(map.get("first"));
		
		
		System.out.println(Print.getInt());
		
		
		
		
		

	}

	static void checkNow(Integer a) {
		a = new Integer(16);
	}

	static void checkType(ArrayList<String> abc) {
		System.out.println(abc.getClass());
	}

	static void checkFor() {
		System.out.println("\n\n\n\n\n");
		for (int i = 0; i < 5 && 4 < 5; i++) {
			System.out.println(i);
		}
		System.out.println("nothing");
	}

}
	
class IntCheck {
	void checkNow(int[] arr) {
		for (int a = 0; a < arr.length; a++)
			arr[a] += 1;
	}
}

class Print{
	private static int a;
static {
		a=10;
	}
	static int getInt(){
		return a;
	}
}