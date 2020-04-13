package third.step;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryWithResources 
{
  public static void main(String[] args) 
 {
  String dbUrl="jdbc:mysql://localhost:3306/heja10_db?user=root&password=root";
  String query="select * from student_info";
  
  try( Connection con = DriverManager.getConnection(dbUrl);
		 Statement stmt= con.createStatement();
		 ResultSet rs= stmt.executeQuery(query);
		 )
 { 
	// Class.forName("com.mysql.jdbc.Driver");
	 while(rs.next())
	 {
		 System.out.println("Inside rs");
	 }} 
 catch ( SQLException e) 
 {

	e.printStackTrace();
}}}
