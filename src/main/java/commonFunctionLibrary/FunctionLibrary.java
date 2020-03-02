package commonFunctionLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import utilities.Propertyfileutil;
public class FunctionLibrary {
public WebDriver driver;
	
	public WebDriver startBrowser() throws Exception{

		if(Propertyfileutil.getValueForKey("Browser").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(Propertyfileutil.getValueForKey("Browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(Propertyfileutil.getValueForKey("Browser").equalsIgnoreCase("ie")){
			System.setProperty("webdriver.InternetExplorer.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else{
			System.out.println("invalid browser");
		}
		
		return driver;
	}
	
	
	public void openApplication() throws Exception{
		driver.get(Propertyfileutil.getValueForKey("Url"));
		driver.manage().window().maximize();
	}
	
	public void closeBrowser(){
		 driver.close();
	}
}
