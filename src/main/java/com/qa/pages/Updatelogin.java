package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.utils.Utils;

public class Updatelogin extends Utils  {
	
	@FindBy(name = "LOGIN")
	WebElement Login;
	
	@FindBy(name = "Diagnostic LPx - Test")
	WebElement title;
	
	public Updatelogin() {
		System.out.println("login");
		PageFactory.initElements(driver, this);
	}
	
	public void login() throws Exception {
		
		Thread.sleep(7000);
	 driver.findElementByAccessibilityId("atmLOGIN").click();	
		
	}
	public String verifypagename() {
		//System.out.println(title.getText());
		return title.getText();
		
		 
	}
	}


