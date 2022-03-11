package training.fetchData;

interface Message {
	String greet();

	String sayonara();
}

abstract class Anonymous {
	public abstract void myMethod();
}

public class AnonymousInnerClass {

	static int x = 10;

	public void displayMessage(Message m) {
		System.out.println(m.greet());
		System.out.println(m.sayonara());
	}

	static class Nested_Demo {
		public void my_nethod() {
			System.out.println("This is my nested class");
		}
	}

	public static void main(String args[]) {
		System.out.println(x);
		Anonymous anin = new Anonymous() {

			@Override
			public void myMethod() {
				// TODO Auto-generated method stub
				System.out.println("Anonymous Inner class");
			}
		};
		anin.myMethod();

		AnonymousInnerClass obj = new AnonymousInnerClass();
		obj.displayMessage(new Message() {
			public String greet() {
				return "hello";
			}

			public String sayonara() {
				return "bye";
			}

		});
		
		AnonymousInnerClass.Nested_Demo nst=new AnonymousInnerClass.Nested_Demo();
		nst.my_nethod();
	}
}
