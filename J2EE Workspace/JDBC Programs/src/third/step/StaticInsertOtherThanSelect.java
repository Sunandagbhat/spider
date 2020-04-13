package third.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StaticInsertOtherThanSelect 
{
  public static void main(String[] args)
  { 
	Connection con=null;
	Statement stmt=null;
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
		String query1= "insert into student_info Values(11,'ABC','N/A',78.7)";
		String query2= "insert into student_info Values(12,'ABC','N/A',78.7)";
		String query3= "insert into student_info Values(13,'ABC','N/A',78.7)";
		String query4= "insert into student_info Values(14,'ABC','N/A',78.7)";
		String query5= "insert into student_info Values(15,'ABC','N/A',78.7)";	    
		
		stmt= con.createStatement();
	    stmt.addBatch(query1);
		stmt.addBatch(query2);
		stmt.addBatch(query3);
		stmt.addBatch(query4);
	    stmt.addBatch(query5);
		int[] count=stmt.executeBatch();
		
	  for(int i=0;i<count.length;i++)
	  {
		System.out.println("Query ok  "+count[i]+" no.of rows affected");
	  }
	  stmt.clearBatch();
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
		}		
}}}
