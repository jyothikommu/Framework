package framework.framework.testscripts;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import framework.framework.testbase.BaseTest;

import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class FBLogin extends BaseTest{
	//public static WebDriver driver;
  @Test
  public void testVerifyTitle(Method testTitle) throws Exception {
	    Thread.sleep(5000);
	    //openTestApp("chrome", "https://www.facebook.com/login/");
		String title=driver.getTitle();
		System.out.println("title");
		String expectedtitle="Facebook - log in or sign up";
		//extentTest=extentReport.createTest(testTitle.getName());
		extentTest.info(testTitle.getName()+"test execution starts");
		if(title.equalsIgnoreCase(expectedtitle))
      {
			extentTest.info("facebook homepage is displayed");
			extentTest.log(Status.PASS, testTitle.getName());
	   //System.out.println("facebook homepage displayed");
      }
		else
      {
    	  extentTest.info("facebook homepage is not displayed");
    	  extentTest.log(Status.FAIL, testTitle.getName());
    	 // System.out.println("facebook homepage is not displayed");
      }
  }

}
