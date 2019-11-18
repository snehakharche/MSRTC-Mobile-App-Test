package com.testdroid.appium.android.msrtc.PageObject;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PassengerInfoPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	
	@CacheLookup
	@AndroidFindBy(id= "edtMobileNumber")
	AndroidElement mobileNo;
	
	@CacheLookup
	@AndroidFindBy(id= "edtName1")
	AndroidElement Name;
	
	@CacheLookup
	@AndroidFindBy(id= "edtAge1")
	AndroidElement Age;
	
	@CacheLookup
	@AndroidFindBy(id="btnContinueConfirmation")
	AndroidElement btnProceed;
	
	public PassengerInfoPage(AndroidDriver<AndroidElement> driver)  {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 20);
		
	}
	public void Proceed() throws InterruptedException
	{
		Thread.sleep(5000);
		mobileNo.sendKeys("8793470779");
		Name.sendKeys("Sneha");
		Age.sendKeys("29");
		
		btnProceed.click();
	}
}
