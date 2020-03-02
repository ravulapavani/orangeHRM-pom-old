package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.Excelfileutil;

public class Loginpage {

	 @FindBy(id="txtUsername")
	 public WebElement userName;
	 
	 @FindBy(id="txtPassword")
	    public WebElement password;
	 
	 @FindBy(id="btnLogin")
	    public WebElement btnLogin;
	 
	 WebDriver driver;
	 
	 public Loginpage(WebDriver driver) {
		
		 
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
		 	 
	 }
	 
	 
	 
	  public void login(Excelfileutil exlu,String tcid){ 
		  
		  int testcaseRow= exlu.getTestcaseRow(tcid);
		  
		  String uname=exlu.getData("TestData", testcaseRow, 1);
		  String pwd=exlu.getData("TestData", testcaseRow, 2);
		  
		  userName.sendKeys(uname);
		  password.sendKeys(pwd);
		  btnLogin.click();
		  
	  }
}
