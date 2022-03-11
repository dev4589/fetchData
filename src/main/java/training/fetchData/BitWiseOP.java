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
	
	}
}
