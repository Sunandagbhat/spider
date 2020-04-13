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

public class StaticSelect 
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
			String query= "Select * from student_info";
			Statement stmt= con.createStatement();
			ResultSet rs=stmt.executeQuery(query);	
			System.out.println(rs);
					
			while(rs.next())
		  {
			 System.out.println("id= "+rs.getInt(1));
			 System.out.println("first name= "+rs.getString(2));
			 System.out.println("last name= "+rs.getString(3));
			 System.out.println("marks= "+rs.getDouble(4));
			 System.out.println("------------------------");
		 }}
			catch (IOException |SQLException e)
		{
			e.printStackTrace();
	}}}