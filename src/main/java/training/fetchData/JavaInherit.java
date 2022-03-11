package training.fetchData;

class Calculation {
	int z;
	private String print;

	Calculation(){
		print="bye";
	}
	Calculation(String print){
		this.print=print;
	}
	public void add(int x, int y) {
		z = x + y;
		System.out.println("The sum of numbers:" + z);
	}

	public void sub(int x, int y) {
		z = x - y;
		System.out.println("The difference numbers:" + z);
	}
	
	public void print() {
		System.out.println(print);
	}
	String getPrint() {
		return print;
	}
}

public class JavaInherit extends Calculation {
	JavaInherit(String print){
		super(print);
	}
	JavaInherit(){}

	public void print() {
		JavaInherit demoPrint=new JavaInherit();
		System.out.println(demoPrint.getPrint());
//		super.print();
	}
	public void multiple(int x, int y) {
		z = x * y;
		System.out.println("The product of numbers:" + z);
	}

	public static void main(String args[]) {
		
		int a = 20, b = 10;
		JavaInherit demo = new JavaInherit("hello");
		demo.add(a, b);
		demo.sub(a, b);
		demo.multiple(a, b);
		demo.print();
		Calculation hello=new Calculation("hello");
		hello.print();
	}
}