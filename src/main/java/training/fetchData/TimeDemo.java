package training.fetchData;

import java.util.Date;

public class TimeDemo {
	public static void main(String args[]) {
		try {
			System.out.println(new Date()+"\n");
			Thread.sleep(5*60*10);
			System.out.println(new Date()+"\n");
		}
		catch(Exception e){
			System.out.println("Got an Exception!");
		}
		
		try {
			long start=System.currentTimeMillis();
			System.out.println(new Date()+"\n");
			
			Thread.sleep(5*60*10);
			System.out.println(new Date()+"\n");
			
			long end=System.currentTimeMillis();
			long diff=end-start;
			System.out.println("Difference is: "+diff);
			
		}
		catch(Exception e) {
			System.out.println("Got an Exception!");
		}
		
	}
}
