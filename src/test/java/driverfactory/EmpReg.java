package driverfactory;

public class EmpReg {

	import java.io.File;


	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.Test;

	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;
	import com.relevantcodes.extentreports.LogStatus;

import commonFunctionLibrary.FunctionLibrary;
import pages.HomePage;
	
import pages.Loginpage;
import utilities.Excelfileutil;

	
		@Test
		  public void f() throws Throwable {
			     Excelfileutil excel=new Excelfileutil();
				FunctionLibrary fl=new FunctionLibrary();
				 Loginpage lp = null;
				 HomePage hp = null;	
				 
				 ExtentReports report;
				 ExtentTest test = null;
				 WebDriver driver=null;
				 
				 String testcaseName=excel.getData("MasterTestCases", 2, 2);
				 String testcaseId_Mastertestcases=excel.getData("MasterTestCases", 2, 0);
				 report=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\"+testcaseName+"_"+FunctionLibrary+".html");
				 
				 for(int j=1;j<=excel.rowCount(testcaseName);j++)
				  {	
					  test=report.startTest(testcaseName);	
					  String step_Description=excel.getData(testcaseName, j, 1);
					  String functionName=excel.getData(testcaseName, j, 2);
					  String page=excel.getData(testcaseName, j, 3);				  
					  try{   
						  	if(functionName.equalsIgnoreCase("startBrowser")){
								driver=fl.startBrowser();
								test.log(LogStatus.INFO, step_Description);		
							}
							if(functionName.equalsIgnoreCase("openApplication")){
								fl.openApplication();
								test.log(LogStatus.INFO, step_Description);
							}
							if(functionName.equalsIgnoreCase("login")){
								lp=new Loginpage(driver);
								lp.login(excel, testcaseId_Mastertestcases);
								test.log(LogStatus.INFO, step_Description);
							}
							if(functionName.equalsIgnoreCase("logout")){
								hp=new HomePage(driver);
								hp.logout();
								test.log(LogStatus.INFO, step_Description);	
							}
							if(functionName.equalsIgnoreCase("empReg")){
								hp=new HomePage(driver);
								hp.EmployeeRegistration(excel, testcaseId_Mastertestcases);
								test.log(LogStatus.INFO, step_Description);	
							}
							if(functionName.equalsIgnoreCase("userReg")){
								hp=new HomePage(driver);
								hp.UserRegistration(excel, testcaseId_Mastertestcases);
								test.log(LogStatus.INFO, step_Description);	
							}
							if(functionName.equalsIgnoreCase("closeBrowser")){
								fl.closeBrowser();
								test.log(LogStatus.INFO, step_Description);	
							}	
							fl.status="PASS";
							excel.setData2(testcaseName, j, 3, fl.status,testcaseName);
							test.log(LogStatus.PASS, testcaseName);	
						}catch(Exception e) {
							e.printStackTrace();
							fl.status="FAIL";
							excel.setData2(testcaseName, j, 3, fl.status,testcaseName);
							test.log(LogStatus.FAIL, testcaseName);	
							File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"\\Screenshots\\"+step_Description+FunctionLibrary.generateDate()+".png"));
							break;
						}
				  }  
				 
				  report.endTest(test);
				  report.flush();
				  
				  if(fl.status.equalsIgnoreCase("PASS")) {
					  excel.setData2("MasterTestCases",2, 4, "PASS",testcaseName);
				  }else {
					  excel.setData2("MasterTestCases",2, 4, "FAIL",testcaseName);
				  }		
		  }
	}

}
