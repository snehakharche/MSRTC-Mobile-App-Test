package com.testdroid.appium.android.msrtc.PageObject;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SelectSeatsPage {
		
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.TableLayout[@resource-id='com.expscs.msrtc:id/tblSeatLayout']//android.widget.TextView[@resource-id='com.expscs.msrtc:id/SeatNo']")
	List<AndroidElement> seats;
	
	@CacheLookup
	@AndroidFindBy(id="btnNext")
	AndroidElement btnNext;
	
	public SelectSeatsPage(AndroidDriver<AndroidElement> driver)  {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 20);
		
	}
	
	public PassengerInfoPage selectSeat() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("List: "+seats.size());
		seats.get(2).click();
		
		Thread.sleep(2000);
		btnNext.click();
		return new PassengerInfoPage(driver);
	}
}
