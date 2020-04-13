package third.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class DynamicOtherThanSelect
{
public static void main(String[] args)
{
  try
	{
	  Scanner sc=new Scanner(System.in);
	
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
		String query= "insert into student_info Values(?,?,?,?)";
		
		PreparedStatement pstmt= con.prepareStatement(query);
		
		System.out.println("Enter the value for id");
		pstmt.setInt(1, sc.nextInt());
		
		System.out.println("Enter the value for First Name");
		pstmt.setString(2, sc.next());
		
		System.out.println("Enter the value for Last Name");
		pstmt.setString(3, sc.next());
		
		System.out.println("Enter the Marks");
		pstmt.setDouble(4, sc.nextDouble());
		
		int count=pstmt.executeUpdate();
		System.out.println(" Query ok  "+count+" no.of rows affected ");
	}
	
		catch (IOException |SQLException e)
	{
		e.printStackTrace();
}}}