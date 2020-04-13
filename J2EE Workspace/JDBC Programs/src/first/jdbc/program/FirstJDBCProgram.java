package first.jdbc.program;
import java.sql.*;

public class FirstJDBCProgram 
{
	  public static void main(String[] args) 
		{
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		String dbUrl="jdbc:mysql://localhost:3306/heja10_db?user=root&password=root";
		String query="select*from student_info";
		
		try 
		{
			//Load the Driver
			//Driver driver=new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			
			//Get the Connection via Driver
			con=DriverManager.getConnection(dbUrl);
			
			// Issue SQL Queries via Connection
			stmt= con.createStatement();
			rs= stmt.executeQuery(query);
			
			//Process the Result Returned
			System.out.println("Student Records");
			System.out.println("------------------------");
			while(rs.next())
			{
			System.out.println("Id= "+rs.getInt(1));
			System.out.println("First Name= "+rs.getString(2));
			System.out.println("Last Name= "+rs.getString(3));
			System.out.println("Marks= "+rs.getDouble(4));
			System.out.println("------------------------");
		}
			// Close all the JDBC objects
			rs.close();
			stmt.close();
			con.close();
		}
		catch(SQLException e)
		{
		 e.printStackTrace();
		 }}}