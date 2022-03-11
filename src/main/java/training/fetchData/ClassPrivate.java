package training.fetchData;

class SuperClass {
	int num = 10;

	public void move() {
		System.out.println("Animals can move");
	}
	public void move(int x) {
		System.out.println("Animals can move "+x+" km");
	}
}

class SubClass extends SuperClass {
	int num = 10;

	public void move() {
		System.out.println("Animals can not move");
		super.move(5);
	}
}

public class ClassPrivate extends SubClass {

	public static void main(String args[]) {
		ClassPrivate obj = new ClassPrivate();
		System.out.println(obj.num);
		
		SuperClass sp=new SubClass();
		SuperClass sp0=new SuperClass();
		sp.move();
		sp0.move();
	}
}
