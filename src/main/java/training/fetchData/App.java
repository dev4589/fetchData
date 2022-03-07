package training.fetchData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App 
{
    public static void main( String[] args )
    {
        String url="jdbc:mysql://localhost:3306/universityData";
        String user="root";
        String pwd="rootdevansh";
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	Connection connection = DriverManager.getConnection(url,user,pwd);
        	System.out.println("Connection to database " + url + " is successful");
        	String query="select * from studentData";
        	Statement statement=connection.createStatement();
        	ResultSet results=statement.executeQuery(query);
        	while(results.next()) {
        		int id=results.getInt(1);
        		String name=results.getString("name");
        		System.out.println("ID: "+id+" Name: "+name);
        	}
        }
        catch(ClassNotFoundException e) {
        	e.printStackTrace();
        }
        catch(SQLException throwables) {
        	throwables.printStackTrace();
        }
    }
}
