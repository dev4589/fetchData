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
    	 String url="jdbc:mysql://ezcapc-webdb-production-readrep.cncmk5ndlbjo.us-east-1.rds.amazonaws.com:3306/CAPC_APIGATEWAY";
	        String user="read_only";
	        String pwd="P@ssw0rd@123";
        
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
