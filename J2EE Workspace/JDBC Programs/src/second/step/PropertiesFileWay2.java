package second.step;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesFileWay2 
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
			String dbUrl=prop.getProperty("dbUrl");
		    String username=prop.getProperty("user");
		    String password=prop.getProperty("password");
		    
			Connection con = DriverManager.getConnection(dbUrl,username,password);
			System.out.println(con);
			}
			catch (IOException |SQLException e)
			{
				e.printStackTrace();
	}}}
