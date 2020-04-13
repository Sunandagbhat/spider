package third.step;
import java.sql.Connection;

public class ConnectionPoolClient
{

	public static void main(String[] args)
	{
		ConnectionPoolManager cpm;
		Connection con= null;
			try 
			{
				 cpm = new ConnectionPoolManager();
				
				con = cpm.getConnectionFromPool();
				cpm.giveConnectionToPool(con);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
	}}
