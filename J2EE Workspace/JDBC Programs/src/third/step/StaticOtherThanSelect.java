package third.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StaticOtherThanSelect 
{
  public static void main(String[] args)
  {
	  try
	 {
	   // Load the driver
	   //Class.forName("com.mysql.jdbc.Driver");
					
	  File file = new File("D://JAVA/J2EE Workspace/JDBC Programs/pro.properties");
					
	  FileReader reader = new FileReader(file);
	  Properties prop = new Properties();
	  prop.load(reader);
	  String dbUrl=prop.getProperty("dbUrl");
	  String username=prop.getProperty("user");
      String password=prop.getProperty("password");
		     
	  Connection con = DriverManager.getConnection(dbUrl,username,password);
	//String query= "Insert into student_info values(60,'bucky','Rogers',80.2)";
	  String query = "Delete from student_info where id>5";
			
	  Statement stmt= con.createStatement();
	  int count=stmt.executeUpdate(query);
	  System.out.println("Query ok  "+count+" no.of rows affected");
		}
		catch (IOException |SQLException e)
		{
		  e.printStackTrace();
		}}}
				
