package second.step;
import java.sql.*;

public class JDBC2ndSTEP 
{
  public static void main(String[] args) 
   {
	 try 
	 {
   //Load the Driver	
   // String dbUrl="jdbc:mysql://localhost:3306/heja10_db?user=root&password=root";
     //String dbUrl="jdbc:mysql://localhost:3306/heja10_db";

    // Connection con= DriverManager.getConnection(dbUrl);
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/heja10_db","root","root");
          System.out.println(con);
	 }
	 
    catch(SQLException e)
	{
	e.printStackTrace();
		}
      }
  }
