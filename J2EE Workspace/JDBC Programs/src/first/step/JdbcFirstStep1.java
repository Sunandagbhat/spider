package first.step;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class JdbcFirstStep1 
{
	public static void main(String[] args)
	{
	try
	{
		Driver driver = new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(driver);	//here we register one more driver
		Enumeration<Driver> enumeration=DriverManager.getDrivers();
			
		while(enumeration.hasMoreElements())
		{
		  System.out.println(enumeration.nextElement());
		}}
		catch(SQLException e)
			{
			e.printStackTrace();
			}}}

