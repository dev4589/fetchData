package training.abstractMethod;

public class Salary extends Employee {
	private double salary; // Annual salary

	@Override
	public double computePay() {
		// TODO Auto-generated method stub
		System.out.println("Computing salary pay for " + getName());
		return salary / 52;
	}
}