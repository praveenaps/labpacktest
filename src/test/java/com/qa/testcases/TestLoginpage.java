package com.qa.testcases;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.Updatelogin;
import com.qa.utils.Utils;
import com.relevantcodes.extentreports.LogStatus;


public class TestLoginpage extends Utils{
	
//	Loginpage log;
	Updatelogin log;
	
    public TestLoginpage()
    {
		super();
    }
	
    @BeforeMethod
    public void setup() throws Exception
    {
    	initialization();
    	//log = new Loginpage();
    	log = new Updatelogin();
    }
    
    @Test(priority = 1)
	public void logverifytitleofthepage() throws Exception
	{  
		
        String expected = "Diagnostic LPx - Test";
        log.verifypagename();
        Assert.assertEquals(log.verifypagename(), expected);
      String Loginverify = getScreenshot(driver, "AfterSplashscreen");
	    	test.log(LogStatus.INFO, "VefifyLogin" + test.addScreenCapture(Loginverify));
	}

	@Test(priority = 2)
	public void Login() throws Exception
	{
		log.login();
		
		//System.out.println(prop.getProperty("Email"));
		//log.login(prop.getProperty("Email"), prop.getProperty("password"));
	//	Thread.sleep(2000);	
	}
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.quit();
		
	}

}
