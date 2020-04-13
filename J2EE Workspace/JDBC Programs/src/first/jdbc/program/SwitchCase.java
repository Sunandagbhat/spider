package first.jdbc.program;
import java.util.Scanner;
import java.io.IOException;
import java.sql.*;

public class SwitchCase 
{
    public static void main(String[] args) 
   { 
	  Connection con=null;  
	  Statement stmt=null;  
	  ResultSet rs=null; 
	  
	Scanner sc=new Scanner(System.in);
	int choice;
		
	try
  {
	String dbUrl="jdbc:mysql://localhost:3306/heja10_db?user=root&password=root";
    con = DriverManager.getConnection(dbUrl);
	stmt= con.createStatement();
      do
		{
			System.out.println("Enter you choice");
			System.out.println("1:Insert Values");
			System.out.println("2:Delete Values");
			System.out.println("3:Display Values");
			choice= sc.nextInt();
			
			switch(choice)
			{
			case 1: 
				stmt.executeUpdate("insert into student_info values (6,'ABC','XYZ',88.9)");
				System.out.println("Successfully Inserted");
				break;
			case 2: 
				stmt.executeUpdate("delete from student_info where id=6");
				System.out.println("Successfully Deleted");
				break;
			case 3: 
				stmt.executeQuery("select * from student_info");
				System.out.println("Successfully Displayed");
		
				while(rs.next())
				  {
					 System.out.println("id= "+rs.getInt(1));
					 System.out.println("first name= "+rs.getString(2));
					 System.out.println("last name= "+rs.getString(3));
					 System.out.println("marks= "+rs.getDouble(4));
					 System.out.println("------------------------");
				 }
				break;
			}}
		while(choice!=4);
				rs.close();
				stmt.close();
				con.close();
			}
			
					catch (SQLException e)
				{
					e.printStackTrace();
			}}}
