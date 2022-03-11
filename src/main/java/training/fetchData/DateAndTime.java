package training.fetchData;

import java.text.*;
import java.util.*;

public class DateAndTime {
	public static void main(String[]args) {
		Date date = new Date();
		GregorianCalendar greg = new GregorianCalendar();
		System.out.println(greg.get(Calendar.DATE));
		SimpleDateFormat ft=new SimpleDateFormat("E W w k G F yyyy.dd.mm 'at' hh:mm:ss a zzz");
		
		System.out.println(ft.format(date));
		
		
		Calendar c = Calendar.getInstance();
		String s = String.format("Duke's Birthday: %1$tm %2$te,%<ty %TS", c,c);
		System.out.println(s);
		
		
		ft=new SimpleDateFormat("yyyy-MM-dd");
		String input=args.length==0?"1818-11-11":args[0];
		
		System.out.print(input+" parse as ");
		Date t;
		try {
			t=ft.parse(input);
			System.out.println(t);
			
		}
		catch(ParseException p){
			System.out.println("Unparseable using "+ft);
		}
		
	}
}
