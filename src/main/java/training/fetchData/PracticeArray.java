package training.fetchData;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class PracticeArray {
	public static void main(String[] args) {
		int[] arr = { 11, 102, 13, 40, 5 };
		Arrays.sort(arr);
		for (int ele : arr) {
			System.out.println(ele + 1);
		}
		Date date = new Date();
		GregorianCalendar greg = new GregorianCalendar();
		System.out.println(greg.get(Calendar.DATE));
		System.out.println(greg.getMaximum(arr[1]));
	}
}