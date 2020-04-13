package second.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StaticAfterChange 
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
	  String query= "Select first_name,last_name,marks from student_info where id>1";
	  Statement stmt= con.createStatement();
	  ResultSet rs=stmt.executeQuery(query);	
	  System.out.println(rs);
					
	  while(rs.next())
	  {
	   System.out.println("First Name= "+rs.getString(1));
	   System.out.println("last name= "+rs.getString(2));
	   System.out.println("marks= "+rs.getDouble(3));
	   System.out.println("------------------------");
	  }}
	  catch (IOException |SQLException e)
	  {
		e.printStackTrace();
	}}}
