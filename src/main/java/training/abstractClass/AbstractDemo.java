package training.abstractClass;

/* File name : AbstractDemo.java */
public class AbstractDemo {

   public static void main(String [] args) {
    
      Salary s = new Salary("George W.", "Houston, TX", 3,3600.00);
      Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);
      System.out.println("\n Call mailCheck using Employee reference--");
      s.mailCheck();
      System.out.println("\n Call mailCheck using Employee reference--");
      e.mailCheck();
   }
}