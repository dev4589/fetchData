package training.problems;

import java.util.Stack;

public class StackDemo {
	public static void main(String args[]) {
		Stack<Object> sta=new Stack<>();
		sta.add('a');
		sta.add(1);
		sta.pop();
		System.out.println(sta);
	}
}
