package training.fetchData;

class sup{
	void move() {
		System.out.println("move superclass");
	};
}

class sub extends sup{
	void move() {
		System.out.println("move subclass");
	}
}
public class PolymorphismEx {

	public static void main(String args[]) {
		sub a = new sub();
		sub b=(sub)new sup();
		sup c=new sub();
		a.move();
		b.move();
	}
}


