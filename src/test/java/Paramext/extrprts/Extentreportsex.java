package Paramext.extrprts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public  class Extentreportsex {
	
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		String path=System.getProperty("user.dir")+"\\reports\\index.html"; //It will create reports folder in project
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path); // to configure extent report as per our requirement
		reporter.config().setReportName("Web Automation Test Results");
		reporter.config().setDocumentTitle("TestResults");
		
		extent=new ExtentReports();
		
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Parameswar");
			
	}
	
	@Test
	public void initialDemo()
	{
		
		ExtentTest test=extent.createTest("Initial Demo");
 WebDriver driver= new ChromeDriver();
		
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.getTitle());
		
		test.pass("test failed");
		extent.flush();
	}
	

}
