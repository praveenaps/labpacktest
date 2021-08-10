package com.qa.extendreport;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.xml.XmlSuite;
import java.util.List;

import com.qa.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class Extendreport extends Utils {
		//private ExtentReports extent;
		 XSSFWorkbook wb;
		public static ExtentReports extent;
		public static ExtentTest test;
			
		static 
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			extent = new ExtentReports(System.getProperty("user.dir") + "/src/com/qa/Extendrports/Labpack__" + formater.format(calendar.getTime()) + ".html", false);
		System.out.println("Recent Extend Report"+ extent);
		}
		
		public void getresult(ITestResult result)
		{
			if(result.getStatus()==ITestResult.SUCCESS){
				test.log(LogStatus.PASS, result.getName()+ " test is pass");
			}else if(result.getStatus()==ITestResult.SKIP){
				test.log(LogStatus.SKIP, result.getName()+" test is skipped and skip reason is:-"+ result.getThrowable());
			}else if(result.getStatus()==ITestResult.FAILURE){
				test.log(LogStatus.FAIL, result.getName()+ "test is failed:-"+result.getThrowable());
			}else if(result.getStatus()==ITestResult.STARTED){
				test.log(LogStatus.INFO, result.getName()+"");
			}
		}
		

		@AfterMethod()
		public void afterMethod(ITestResult result) throws IOException {
			getresult(result);
			}

		@BeforeMethod()
		public void beforeMethod(Method result) {
			test = extent.startTest(result.getName());
			test.log(LogStatus.INFO, result.getName() + "");
		}
		
		@AfterClass(alwaysRun = true)
		public void endTest() {
			 extent.endTest(test);
		//	System.out.println("Recent"+extent.endTest(test));
			extent.flush();
		}
		

		/*public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
				String outputDirectory) {
			extent = new ExtentReports(outputDirectory + File.separator
					+ "Extent.html", true);

			for (ISuite suite : suites) {
				Map<String, ISuiteResult> result = suite.getResults();

				for (ISuiteResult r : result.values()) {
					ITestContext context = r.getTestContext();

					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				}
			}

			extent.flush();
			extent.close();
		}

		private void buildTestNodes(IResultMap tests, LogStatus status) {
			ExtentTest test;

			if (tests.size() > 0) {
				for (ITestResult result : tests.getAllResults()) {
					test = extent.startTest(result.getMethod().getMethodName());

					test.setStartedTime(getTime(result.getStartMillis()));
					test.setEndedTime(getTime(result.getEndMillis()));

					for (String group : result.getMethod().getGroups())
						test.assignCategory(group);

					if (result.getThrowable() != null) {
						test.log(status, result.getThrowable());
					} else {
						test.log(status, "Test " + status.toString().toLowerCase()
								+ "ed");
					}

					extent.endTest(test);
				}
			}
		}

		private Date getTime(long millis) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(millis);
			return calendar.getTime();
		}*/
	}

