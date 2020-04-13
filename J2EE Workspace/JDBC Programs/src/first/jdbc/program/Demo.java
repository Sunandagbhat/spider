package first.jdbc.program;

import java.sql.*;

public class Demo 
{
	 public static void main(String[] args) throws Exception
		{
		 String Url="jdbc:mysql://localhost:3306/heja10_db";
		 String uname="root";
		 String pass="root";
		String query="select name from employes where id=10 ";
			
		// Class.forName("com.mysql.jdbc.Driver"); 
		// Bcoz of 8.1.13 jar file first step is not required
		
		Connection con=DriverManager.getConnection(Url,uname,pass);	
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery(query);//DDL(Structure),DML(value),DQL(fetch data),TCL
			
		    rs.next();
			String name=rs.getString("name");
			System.out.println(name);
			
			rs.close();
			st.close();
			con.close();
		
		 }}
