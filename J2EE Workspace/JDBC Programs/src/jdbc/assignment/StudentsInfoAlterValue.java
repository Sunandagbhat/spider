package jdbc.assignment;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentsInfoAlterValue 
{
   public static void main(String[] args)
	{
	  try
	  {
		// Load the driver
	    //Class.forName("com.mysql.jdbc.Driver");
					
	 File file = new File("D://JAVA/J2EE Workspace/JDBC Programs/second.properties");
					
	 FileReader reader = new FileReader(file);
	 Properties prop = new Properties();
	 prop.load(reader);
	 String dbUrl=prop.getProperty("dbUrl");
     String username=prop.getProperty("user");
     String password=prop.getProperty("password");
		     
    Connection con = DriverManager.getConnection(dbUrl,username,password);
	String query= "update students_otherinfo set isadmin='N' where regno=1";
			
	Statement stmt= con.createStatement();
	int count=stmt.executeUpdate(query);
	System.out.println("Query ok  "+count+" no.of rows affected");
  }
	catch (IOException |SQLException e)
	{
	  e.printStackTrace();
	}}}
