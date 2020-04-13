// by storing
package second.step;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Properties2ndway 
{
  public static void main(String[] args) throws Exception 
   {
	Properties p=new Properties();
	OutputStream os=new FileOutputStream("dataConfig.properties");
	
	p.setProperty("Url", "localhost:3306/heja10_db");
	p.setProperty("uname", "root");
	p.setProperty("pass", "root");
	p.store(os, null);
	
  }
}

