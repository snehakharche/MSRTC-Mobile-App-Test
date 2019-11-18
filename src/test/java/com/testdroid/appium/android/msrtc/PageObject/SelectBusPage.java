package com.testdroid.appium.android.msrtc.PageObject;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.testdroid.appium.android.msrtc.bitbarcapability.BitbarCapability;
import bsh.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindByAllSet;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;

public class SelectBusPage {
	AndroidDriver<AndroidElement> driver;
	@CacheLookup
	@AndroidFindBy(id="shivnerit")
	AndroidElement clickShivneri;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Open navigation drawer']")
	AndroidElement clickMenu;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='com.expscs.msrtc:id/navList']//android.widget.LinearLayout[2]//android.widget.TextView[@resource-id='com.expscs.msrtc:id/txtListItemText']")
	AndroidElement LoginMenu;
	
	WebDriverWait wait;
	
	public SelectBusPage() throws MalformedURLException {
		this.driver = BitbarCapability.Capability();
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		wait = new WebDriverWait(driver, 20);
	}
	
	public LoginPage selectBus() throws InterruptedException, MalformedURLException
	{
		if(wait.until(ExpectedConditions.alertIsPresent())!=null)
		{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
		Thread.sleep(5000);
		clickShivneri.click();
		clickMenu.click();
		
		Thread.sleep(5000);
		
		LoginMenu.click();
		return new LoginPage(this.driver);
	}
}
