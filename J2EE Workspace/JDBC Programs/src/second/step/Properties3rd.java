// by fetching
package second.step;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Properties3rd 
{
public static void main(String[] args) throws Exception 
{
	Properties p=new Properties();
	InputStream is=new FileInputStream("dataConfig.properties");
	p.load(is);
	System.out.println(p.getProperty("uname"));
	System.out.println(p.getProperty("Url"));
	
	p.list(System.out);
}
}

