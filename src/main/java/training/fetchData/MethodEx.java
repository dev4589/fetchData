package training.fetchData;
import java.util.Scanner;

public class MethodEx {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		CheckNum check=new CheckNum(n);
		check.printNum();
//		System.out.println("from  object"+check.num);
	}
	
}

class CheckNum{
	private int num;
	CheckNum(int num){
		this.num=num;
	}
	void printNum(){
		System.out.println("from method"+num);
	}
}