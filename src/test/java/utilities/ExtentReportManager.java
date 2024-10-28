package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
 
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent; //populate common info on the report
	public ExtentTest test; //creating test cases entries in the report and update status of thtest methods
	
	String repname;
	
	public void onStart(ITestContext testContext) {
		
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repname = "TestReport-" + timestamp + ".html";
		
		
		sparkReporter = new ExtentSparkReporter( ".\\reports\\" + repname);//specify the ;pcation
		sparkReporter.config().setDocumentTitle("opencart Automation report");
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Opencart Functional Testing");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "opencar");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("Sub Module", "Customers");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");
		//will check for OS from XML
		String os =testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
			//will check for browser from XML
		String browser =testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("browser", browser);
		
	//Will check for Group name from XML	
	List<String>includeGroups=testContext.getCurrentXmlTest().getIncludedGroups();
	if(!includeGroups.isEmpty()) {
		extent.setSystemInfo("Groups", includeGroups.toString());
	}
	
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		

		test = extent.createTest(result.getTestClass().getName()); // to display the class name
		test.assignCategory(result.getMethod().getGroups()); //to display the group name
		test.log(Status.PASS, "Test case passed is:" + result.getName());
		
	}
	public void onTestFailure(ITestResult result)
	{
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test case Failed is:" + result.getName());
		test.log(Status.INFO, "Test case Failed cause is:" + result.getThrowable().getMessage());

		try {
			String imgpath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result)
	{
		
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case Failed is:" + result.getName());
		test.log(Status.INFO, "Test case Failed cause is:" + result.getThrowable().getMessage());

	}
	
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
		//this code will automatically open the file of the report
		String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repname;
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());

		}catch (IOException e) {
			e.printStackTrace();
		}
		
		//you can send the report in email  - 1:11:54 time https://www.youtube.com/watch?v=xeEVNVEVefM&list=PLUDwpEzHYYLtQzEEEldbjPAR-gnStv4sR&index=5
		
	}
}
