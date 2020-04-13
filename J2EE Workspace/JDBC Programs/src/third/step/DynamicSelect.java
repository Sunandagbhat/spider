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

public class DynamicSelect 
{
  public static void main(String[] args)
  {
	Connection con=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;		
			 	 
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
	     
	    con = DriverManager.getConnection(dbUrl,username,password);
		String query= "Select * from student_info where id>? and marks>?";
	    pstmt= con.prepareStatement(query);
		System.out.println("Enter the value for id");
		pstmt.setInt(1, sc.nextInt());
		
		System.out.println("Enter the marks");
		pstmt.setDouble(2, sc.nextDouble());
		
		 rs=pstmt.executeQuery();	
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
    }
	 finally
	 {
		 try
		 {
		   if(rs!=null)
		   rs.close();
		   if(pstmt!=null)
		   pstmt.close();
		   if(con!=null)
		   con.close();
		 }				 
		 catch (SQLException e)
			{
				e.printStackTrace();
		} }}}				
