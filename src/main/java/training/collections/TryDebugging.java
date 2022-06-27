package training.collections;

import java.util.ArrayList;
import java.util.List;

public class TryDebugging {

	public static void main(String[] args) {
//		List<Integer> count=new ArrayList<>();
//		count=add(count);
//		dis(count);
		EnumWithValue abc=EnumWithValue.FIRST;
		System.out.println(abc);
	}
	static List<Integer> add(List<Integer> count) {
		int index;
		for(index=0;index<6;index++) {
			count.add(index);
		}
		return count;
	}
	
	static void dis(List<Integer> count){
		for(Integer i:count) {
			System.out.println(i);
		}
	}

}
