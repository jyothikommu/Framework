package framework.framework.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
//extent is created or not
public static ExtentReports extentReport;
public static ExtentSparkReporter htmlReport;
//verify extent file is exist or not
public static ExtentReports getInstance()
{
	if (extentReport==null)
	{
		return createInstance();
	}
	else {
		return extentReport;
	}

}
public static ExtentReports createInstance() {
	htmlReport=new ExtentSparkReporter(System.getProperty("user.dir")+"\\test-output\\MyReports\\MyReport.html");
	htmlReport.config().setDocumentTitle("MySampleReport");
	htmlReport.config().setReportName("AutomationReport");
	htmlReport.config().setTheme(Theme.DARK);
	
	//create extent report
	extentReport=new ExtentReports();
	//add test name
	extentReport.setSystemInfo("hostname", "jyothi");
	extentReport.attachReporter(htmlReport);
	return extentReport;
	
}

	

}
