package third.step;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

public class ConnectionPoolManager 
{
   private String dbUrl="jdbc:mysql://localhost:3306/heja10_db";
   private  String username="root";
   private  String password="root";
   private Vector<Connection> pool=new Vector<Connection>();// vector is fast
   private final int POOL_SIZE=10;
   public static ConnectionPoolManager instance=null;
   
   public static ConnectionPoolManager getInstance()throws Exception
   {
	   if(instance==null)
	   {
		   instance = new ConnectionPoolManager();   
	   }
	   return instance;
   }
   ConnectionPoolManager() throws Exception
   {
	   System.out.println("Connection pool creation started");
	   // Class.forName("com.mysql.jdbc.Driver");
	   
	   for(int i=0;i<POOL_SIZE;i++)
	   {
		  Connection con=DriverManager.getConnection(dbUrl,username, password);
		  pool.add(con);
	   }}
		public Connection getConnectionFromPool() throws Exception
		{ 
			System.out.println("Pool size Before giving = "+pool.size());
			
			Connection con=null;
			if(pool.size()>0)
			{
				con=pool.get(0);
				pool.remove(0);
				System.out.println("Pool size After giving = "+pool.size());
				
				return con;
			}
			else
			{
				con=DriverManager.getConnection(dbUrl,username, password);
				}
			
			System.out.println("Pool size After giving = "+pool.size());
			return con;
			}
		public void giveConnectionToPool(Connection con)
		{
			if(pool.size()>POOL_SIZE)
			{
				System.out.println("Pool is full");}
			else
			{
				pool.add(con);
			}
			System.out.println("Pool size After Receiving = "+pool.size());
					
		}}

				
				
