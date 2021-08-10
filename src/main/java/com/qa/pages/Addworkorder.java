package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.qa.excelReader.excelReader;
import com.qa.testbase.Testbase;
import com.relevantcodes.extentreports.LogStatus;

public class Addworkorder extends Testbase {
	
	Testbase base = new Testbase();
	excelReader data = new excelReader("C:\\Users\\praveena\\eclipse-workspace\\Labpack\\src\\main\\java\\com\\qa\\testdata\\container.xlsx");

	@FindBy(name ="GET WORK ORDER")
	public
	WebElement Getworkorderbutton;
	
	@FindBy(xpath = "atmNewWorkOrderID")
    WebElement WorkorderID;
	
	@FindBy(className = "TextBox")
	WebElement tripid;
	
	@FindBy(how=How.ID_OR_NAME, using="atmNewWorkOrderID")
	WebElement auto;
	
	@FindBy(name = "GET")
	WebElement save;
	
	@FindBy(name ="GET WORK ORDER")

	WebElement Getworkorderpopup;
	
	public Addworkorder() {
		PageFactory.initElements(driver, this);
	}

	public String verifypagename() throws InterruptedException {
		Thread.sleep(5000);
		Getworkorderbutton.click();
		return Getworkorderpopup.getText();
	}

	public void addworkorder() throws InterruptedException {
		try {
		Thread.sleep(5000);
		Getworkorderbutton.click();
		Thread.sleep(9000);
		
		test.log(LogStatus.INFO, "Enter the workorder Number");
		WebElement orderid =driver.findElementByAccessibilityId("atmNewWorkOrderID");
		orderid.click();
		orderid.sendKeys(data.getData(0, 1, 0));
		
		test.log(LogStatus.INFO, "Entering the NewTrip Number");
		WebElement test =driver.findElementByAccessibilityId("atmNewTripID");
		test.click();
		test.sendKeys(data.getData(0, 1, 1));
		Thread.sleep(5000);
		
		save.click();
		Thread.sleep(6000);
		}
		catch(Exception e)
		{
			System.out.println("Exception" + e);
		}
		
	}

	public void search() throws InterruptedException
	{
		try {
		Thread.sleep(5000);
		WebElement search =driver.findElementByAccessibilityId("atmSearch");
		search.click();
		search.sendKeys("93888");
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement search1 =driver.findElementByAccessibilityId("atmGridView");
		actions.doubleClick(search1).perform();
		//actions.click(search1);
		}
		catch(Exception e)
		{
		System.out.println("Exception" + e);
		}
	}

	public void filter() throws InterruptedException
	{
		
		Thread.sleep(5000);
		WebElement filter =driver.findElementByAccessibilityId("atmFilter");
		filter.click();
		
		Thread.sleep(5000);
		WebElement filterlst =driver.findElementByName("COMPLETED");
		filterlst.click();
		
		Thread.sleep(5000);
		WebElement lstview =driver.findElementByAccessibilityId("atmListView");
		lstview.click();
		
		Thread.sleep(3000);
		WebElement sync =driver.findElementByAccessibilityId("atmSync");
		sync.click();
		
		Thread.sleep(3000);
		WebElement upload =driver.findElementByAccessibilityId("atmUpload");
		//upload.click();
	}
	}

