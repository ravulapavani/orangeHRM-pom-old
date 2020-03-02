package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {

	@FindBy(id="welcome")
    public WebElement lnkwelcome;
    
    @FindBy(linkText="Logout")
    public WebElement lnklogout;
    
    WebDriver driver;
    
    public HomePage(WebDriver driver) {
    	this.driver=driver;
		PageFactory.initElements(driver, this);
    }
    
    public void logout() throws Exception {
    	Thread.sleep(3000);
    	lnkwelcome.click();
    	Thread.sleep(5000);
    	lnklogout.click();
    }
    

}
