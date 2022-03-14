package training.fetchData;

class DemoObjectData {
	
	private int age=0;
	DemoObjectData(String name,int age){
		this.age=age;
		System.out.println(name);
	}
	void setAge(int age) {
		this.age=age;
	}
	int getAge() {
		return age;
	}
	
}
public class DemoObject{
	void print() {
		System.out.println("hello");
	}
	public static void main(String arguments[]) {
		DemoObjectData test=new DemoObjectData("Dev",5);	
		System.out.println(test.getAge());
		test.setAge(4);
		System.out.println(test.getAge());
		DemoObject printLine=new DemoObject();
		printLine.print();
		
	}
}