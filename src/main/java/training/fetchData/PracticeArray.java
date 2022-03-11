package training.fetchData;

import java.util.Arrays;

class PracticeArray {
	public static void main(String[] args) {
		int[] arr = { 11, 102, 13, 40, 5 };
		Arrays.sort(arr);
		for (int ele : arr) {
			System.out.println(ele + 1);
		}
		
		int[] arr2=reverse(arr);
		System.out.println("Reverse array");
		for(int i:arr2)
			System.out.println(i);
	}
	public static int[] reverse(int[] arr) {
		int [] arr2=new int[arr.length];
		
		for(int i=0,j=arr.length-1;i<arr.length;i++,j--)
			arr2[j]=arr[i];
		return arr2;
	}
}