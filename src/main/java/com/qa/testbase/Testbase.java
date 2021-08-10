package com.qa.testbase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.windows.WindowsDriver;

public class Testbase {

	//public static WebDriver driver;
	 public static WindowsDriver<RemoteWebElement> driver=null;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test;

	static {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir") + "/src/main/java/com/qa/Extendreports/LabpackReport__"
				+ formater.format(calendar.getTime()) + ".html", false);
	}

	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP,
					result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + "test is failed:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + "test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		extent.endTest(test);
		extent.flush();
	}

	/*public Testbase() {
        System.out.println("get config");
		prop = new Properties();
		FileInputStream Filepath = null;
		try {
			
			Filepath = new FileInputStream(
					"C:\\Users\\praveena\\eclipse-workspace\\Labpack\\src\\main\\java\\com\\qa\\config\\config.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception");
			e.printStackTrace();
		}
		try {
			prop.load(Filepath);
			//System.out.println(prop.load(Filepath));
			//System.out.println("get config1");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	 
	public static void initialization() throws Exception {
		 
		        System.out.println("Initiate the App");
		        DesiredCapabilities dc = new DesiredCapabilities();
		        
		      
		      //  dc.setCapability("app", "USEcologyInc.DiagnosticLPx_6be4g8fa3mj9e!App");
		        dc.setCapability("app", "USEcologyInc.DiagnosticLPx_6be4g8fa3mj9e!App");
		
		        driver= new WindowsDriver<RemoteWebElement>(new URL("http://127.0.0.1:4723"), dc);
		

	}

	

	}

