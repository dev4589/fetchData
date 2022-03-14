package training.fetchData;

public class BitWiseOP {
	
	public static void main(String args[]) {
		char a='a';
		char b='b';
		System.out.println( a & b );	//01100000
		System.out.println( a | b );	//01100011
		System.out.println( a ^ b );	//00000011
		System.out.println( ~ a );		//10011110
		System.out.println( a<<3 );		//001100001000
		System.out.println( a>>2 );		//011000
		System.out.println( a>>>4 );	//0110
		Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
	      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
	      System.out.println("Call mailCheck using Salary reference --");   
	      s.mailCheck();
	      System.out.println("\n Call mailCheck using Employee reference--");
	      e.mailCheck();
	}
}
