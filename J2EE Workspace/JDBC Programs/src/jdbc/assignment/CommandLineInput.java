package jdbc.assignment;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CommandLineInput 
{
public static void main(String[] args) 
{
Connection con=null;
PreparedStatement pstmt=null;	

try
{ 
	 Scanner sc=new Scanner(System.in);

	 File file = new File("D://JAVA/J2EE Workspace/JDBC Programs/second.properties");
			
	FileReader reader = new FileReader(file);
	Properties prop = new Properties();
	prop.load(reader);
	String dbUrl=prop.getProperty("dbUrl");
    String username=prop.getProperty("user");
     String password=prop.getProperty("password");
     
   con = DriverManager.getConnection(dbUrl,username,password);
	String query= "insert into students_otherinfo Values(?,?,?,?)";
	 pstmt= con.prepareStatement(query);
	
	System.out.println("Enter the value for regno");
	pstmt.setInt(1, sc.nextInt());
	
	System.out.println("Enter the value for first_name ");
	pstmt.setString(2, sc.next());
	
	System.out.println("Enter the value for middle_name ");
	pstmt.setString(3, sc.next());
	
	System.out.println("Enter the value for last_name ");
	pstmt.setString(4, sc.next());
	
	int count=pstmt.executeUpdate();
	for(int i=0;i<args.length;i++)	
	{
		System.out.println(args[i]);
	}
	String query2= "insert into guardian_info Values(?,?,?,?)";
	
	 pstmt= con.prepareStatement(query2);
	
	System.out.println("Enter the value for gfirstname ");
	pstmt.setString(1, sc.next());
	
	System.out.println("Enter the value for gmiddlename ");
	pstmt.setString(2, sc.next());
	
	System.out.println("Enter the value for glastname");
	pstmt.setString(3, sc.next());
	
	System.out.println("Enter the value for password ");
	pstmt.setString(4, sc.next());
	
	int count2=pstmt.executeUpdate();
	for(int i=0;i<args.length;i++)	
	{
		System.out.println(args[i]);
	}}
	

	catch (IOException |SQLException e)
{
	e.printStackTrace();
}}}

