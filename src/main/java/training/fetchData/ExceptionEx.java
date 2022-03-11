package training.fetchData;

import java.io.*;

public class ExceptionEx {
	public static void main(String args[]) {
		int arr[] = { 1, 5, 8, -9 };
		try {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i + 1]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
}
