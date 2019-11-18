package com.testdroid.appium.android.msrtc.PageObject;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BusesListPage {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='com.expscs.msrtc:id/lstBusServices']//android.widget.TextView[@resource-id='com.expscs.msrtc:id/txtRouteVal']")
	List<AndroidElement> listOfBuses;
	
	@CacheLookup
	@AndroidFindBy(id="btnSelectSeats")
	AndroidElement btnSelectSeat;
	
	
	
	public BusesListPage(AndroidDriver<AndroidElement> driver)  {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 20);
		
	}
	
	public SelectSeatsPage selectBusFromList() throws InterruptedException
	{
		Thread.sleep(3000);
		System.out.println("List: "+listOfBuses.size());
		
		
		listOfBuses.get(0).click();

		Thread.sleep(3000);
		btnSelectSeat.click();
		
		return new SelectSeatsPage(driver);
	}
}
