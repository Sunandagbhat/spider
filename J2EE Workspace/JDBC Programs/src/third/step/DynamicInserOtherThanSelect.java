//Batch Processing
package third.step;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class DynamicInserOtherThanSelect 
{
public static void main(String[] args)
{  
	Connection con=null;
	PreparedStatement pstmt=null;
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
		String query= "insert into student_info Values(?,?,?,?)";
		pstmt= con.prepareStatement(query);
		
		pstmt.setInt(1, 10);
		pstmt.setString(2, "ABCD");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 87);
		pstmt.addBatch();
		
		pstmt.setInt(1, 6);
		pstmt.setString(2, "ABCD");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 87);
		pstmt.addBatch();
		
		pstmt.setInt(1, 7);
		pstmt.setString(2, "ABCD");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 87);
		pstmt.addBatch();
		
		pstmt.setInt(1,8);
		pstmt.setString(2, "ABCD");
		pstmt.setString(3, "N/A");
		pstmt.setDouble(4, 87);
		pstmt.addBatch();
		
		int[] count=pstmt.executeBatch();
		for(int i=0;i<count.length;i++)
		{
		  System.out.println("Query ok  "+count[i]+" no.of rows affected");
		}
		pstmt.clearBatch();
		con.commit();
	  }
       catch (IOException |SQLException e)
	    {
		e.printStackTrace();
		try {
			con.rollback();
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}		
	}}}
