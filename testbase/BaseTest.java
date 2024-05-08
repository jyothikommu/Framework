package framework.framework.testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import framework.framework.utilities.ExtentManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
  
  public static ExtentTest extentTest;
  public static WebDriver driver;
  public static ExtentReports extentReport;
 
  @BeforeMethod
  public void fbHome(Method methods) {
	  extentTest=extentReport.createTest(methods.getName());
	  extentTest.log(Status.INFO, methods.getName()+"execution started");
	  extentTest.info(methods.getName()+"Test Execution Starts");
  }

  @AfterMethod
	  public void result(ITestResult result) throws Exception
		{
			if(result.getStatus()==ITestResult.SUCCESS)
			{
			
			extentTest.log(Status.PASS,result.getName());
			String pass =captureScreenshot(driver, result.getName());
			extentTest.addScreenCaptureFromPath(pass);
			
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			extentTest.log(Status.FAIL, result.getName()+"is failed");
			extentTest.log(Status.INFO, result.getThrowable());
			String failed=captureScreenshot(driver, result.getName());
			extentTest.addScreenCaptureFromPath(failed);
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			extentTest.log(Status.SKIP, result.getName()+"is skipped");
			extentTest.log(Status.INFO, result.getThrowable());
			String skip= captureScreenshot(driver, result.getName());
			extentTest.addScreenCaptureFromPath(skip);
		}
		
			driver.quit();
			extentReport.flush();
		}

  @AfterSuite
  public void aftersuite(){
  }
  
  @BeforeClass(alwaysRun = true)
  public void driverInstance()
  {
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.facebook.com/");
  }


  @BeforeSuite 
  public void beforeSuite() {
	  extentReport=ExtentManager.getInstance();
	  
  }

  public String captureScreenshot(WebDriver driver, String filename) throws Exception
	{
		//define simple day design pattern
		String dayname=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//define screenshot
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		//capture source type
		File sourcename=screenshot.getScreenshotAs(OutputType.FILE);
		//set file path and type
		//String destinationpath="D:\\SeleniumAutomation\\Screeshots\\"+dayname+filename+".png";
		String destinationpath= System.getProperty("user.dir")+"\\Screeshots\\"+dayname+filename+".png";
		
		//path convert to file
		File destinationfile=new File(destinationpath);
		//copy to destination folder(copy and paste)
		FileUtils.copyFile(sourcename, destinationfile);
		return destinationpath;
		
}
  
	  
            //set up browser and test application
          /*  public static void setUPBrowser(String browser)
            {
            	switch (browser) {
				case "chrome":
					driver=new ChromeDriver();
					break;
				case "edge":
					driver=new EdgeDriver();
					break;
				case "firefox":
					driver=new FirefoxDriver();
					break;
				default:System.out.println("driver is not created");
				break;
				}
            }
         //open application
            public static void openTestApp(String browsername,String url) {
            	setUPBrowser(browsername);
            	driver.get(url);
            }*/
            
}
