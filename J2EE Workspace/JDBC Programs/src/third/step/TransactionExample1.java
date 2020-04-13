package third.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class TransactionExample1 
{
public static void main(String[] args)
{
  Connection con=null;
  try
  {
	   File file = new File("D://JAVA/J2EE Workspace/JDBC Programs/pro.properties");
				
		FileReader reader = new FileReader(file);
		Properties prop = new Properties();
		prop.load(reader);
		String dbUrl=prop.getProperty("dbUrl");
	    String username=prop.getProperty("user");
	     String password=prop.getProperty("password");
	     
	    con = DriverManager.getConnection(dbUrl,username,password);
	    con.setAutoCommit(false);
	    
		String query1= "insert into student_info Values(?,?,?,?)";
		String query2= "insert into student_info Values(?,?,?,?)";
		
		PreparedStatement pstmt= con.prepareStatement(query1);
		
		pstmt.setInt(1, 80);
		pstmt.setString(2, "ABCD");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 87);

		int count1=pstmt.executeUpdate();
		System.out.println(" Query1 ok  "+count1+" no.of rows affected ");
        
		pstmt= con.prepareStatement(query2);
		
		pstmt.setInt(1, 90);
		pstmt.setString(2, "WXYZ");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 85);

		int count2=pstmt.executeUpdate();
		System.out.println(" Query2 ok  "+count2+" no.of rows affected ");
		con.commit();
	}
	
		catch (IOException |SQLException e)
	{
		e.printStackTrace();
		
		try 
		{
			con.rollback();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}}}}
