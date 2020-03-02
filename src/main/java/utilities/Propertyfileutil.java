package utilities;
import java.io.FileInputStream;
import java.util.Properties;
public class Propertyfileutil {
public static String getValueForKey(String Key) throws Exception{
		
		Properties p=new Properties();
		
		FileInputStream fis=new FileInputStream("D:\\pavani_82\\OrangeHRM_POM\\Properties\\Environment.properties");
		
		p.load(fis);
		
	    return p.getProperty(Key);

	}

}


