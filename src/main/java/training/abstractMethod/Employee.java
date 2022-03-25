package training.abstractMethod;

public abstract class Employee {
	private String name;
//	private String address;
//	private int number;
	
	public abstract double computePay();
	public String getName() {
	      return name;
	   }
}
