package first.step;

import java.util.Enumeration;
import java.sql.*;

public class ClassForName 
{
	 public static void main(String[] args)
		{
		try
		{
			//Driver driver = new com.mysql.jdbc.Driver();
			//DriverManager.registerDriver(driver);
			
			// Class.forName("com.mysql.jdbc.Driver");
			Enumeration<Driver> enumeration=DriverManager.getDrivers();
			
			while(enumeration.hasMoreElements())
			{
				System.out.println(enumeration.nextElement());
			}}
	   catch(Exception e)
	   //(ClassNotFoundException e)
		{
		   e.printStackTrace();
		}}}
