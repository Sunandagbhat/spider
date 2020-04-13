package second.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class PropertiesFileWay 
{
	public static void main(String[] args) 
	{
		try
		{
		// Load the driver
		 //Class.forName("com.mysql.jdbc.Driver");
		
		File file = new File("D://JAVA/J2EE Workspace/JDBC Programs/pro.properties");
		
		FileReader reader = new FileReader(file);
		Properties prop = new Properties();
		
		prop.load(reader);
		String dbUrl="jdbc:mysql://localhost:3306/heja10_db";
		Connection con = DriverManager.getConnection(dbUrl,prop);
		System.out.println(con);
		}
		catch (IOException |SQLException e)
		{
			e.printStackTrace();
		}}}
