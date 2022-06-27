package training.fetchData;

import java.util.ArrayList;
import java.util.List;

public class TypeCast {

	public static void main(String args[]) {
		Integer x = 5; // boxes int to an Integer object
		x = x + 10; // unboxes the Integer to a int
		int y = 10;
		System.out.println(x.getClass().getName());
		System.out.println(Math.max(x, y));
		String a = "xyz";
		String b = "abc";
		System.out.println(a.concat(b));
		
		
	}
}
