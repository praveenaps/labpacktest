package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.pages.Addworkorder;

import com.qa.pages.Updatelogin;
import com.qa.utils.Utils;
import com.relevantcodes.extentreports.LogStatus;

public class Testaddworkorder extends Utils {

	Updatelogin log;
	String sheetName = "workorder";
	Addworkorder add;

	public Testaddworkorder() {
		super();
	}

	@BeforeMethod
	public void setup() throws Exception {
		initialization();
		log = new Updatelogin();
		add = new Addworkorder();

		// log.login(prop.getProperty("Email"), prop.getProperty("password"));
	}

	/*
	 * @DataProvider public Object[][] getCRMTestData() {
	 * System.out.println(sheetName); Object data[][] =
	 * Utils.getTestData(sheetName); return data; }
	 */

	/*
	  @Test(priority = 1) public void verifytitleofthepage() throws Exception {
	  log.login();
	  String expected = "GET WORK ORDER";
	  Assert.assertEquals(add.verifypagename(), expected); }
	 
	 

	
	
	  @Test(priority = 2) public void addorder() throws Exception { log.login();
	  test.log(LogStatus.INFO, "Create new work order"); Thread.sleep(6000);
	  add.addworkorder(); String add1 = getScreenshot(driver, "Service info");
	  System.out.println("Workorder created successfully");
	  test.log(LogStatus.INFO, "Workorder created successfully" +
	  test.addScreenCapture(add1));
	  
	  }
	 
	 
		
		  @Test(priority = 3) public void searchworkorder() throws Exception {
		  log.login(); test.log(LogStatus.INFO, "Create new work order"); add.search();
		  Thread.sleep(3000); String add1 = getScreenshot(driver, "Service info");
		  System.out.println("Workorder searched successfully");
		  test.log(LogStatus.INFO, " Workorder Searched" +
		  test.addScreenCapture(add1));
		  }
		 */
		  @Test(priority = 2) 
		  public void filterlist() throws Exception {
			  log.login(); 
			  test.log(LogStatus.INFO, "View filter");
			  add.filter();
			  Thread.sleep(3000);
			  String filter1 = getScreenshot(driver, "Filter");
			  System.out.println("Filtered successfully");
			  test.log(LogStatus.INFO, " Workorder Searched" + test.addScreenCapture(filter1));
			  }

	@AfterMethod
	public void teardown() {
		// driver.quit();
	}
}
