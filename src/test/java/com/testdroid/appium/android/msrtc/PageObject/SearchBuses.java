package com.testdroid.appium.android.msrtc.PageObject;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchBuses {
	
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.expscs.msrtc:id/rlSource']//android.widget.EditText[@resource-id='com.expscs.msrtc:id/aedtSource']")
	AndroidElement source;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.expscs.msrtc:id/rlDestination']//android.widget.EditText[@resource-id='com.expscs.msrtc:id/aedtDestination']")
	AndroidElement destination;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id='com.expscs.msrtc:id/rlDate']//android.widget.EditText[@resource-id='com.expscs.msrtc:id/edtJourneyDate']")
	AndroidElement date;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id='android:id/search_bar']//android.widget.EditText[@resource-id='android:id/search_src_text']")
	AndroidElement searchbox;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.SearchView[@resource-id='com.expscs.msrtc:id/srchSrcDest']//android.widget.EditText[@resource-id='android:id/search_src_text']")
	AndroidElement searchboxDest;
	
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='com.expscs.msrtc:id/lstSourceDestination']//android.widget.TextView[@resource-id='com.expscs.msrtc:id/txtName']")
	List<AndroidElement> list;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id='com.expscs.msrtc:id/lstSourceDestination']//android.widget.TextView[@resource-id='com.expscs.msrtc:id/txtName']")
	List<AndroidElement> listDest;
	
	@CacheLookup
	@AndroidFindBy(id="com.expscs.msrtc:id/btnSearchBus")
	AndroidElement searchBusButton;
	
	public SearchBuses(AndroidDriver<AndroidElement> driver)  {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 20);
		
	}
	public BusesListPage searchBus() throws InterruptedException
	{
		Thread.sleep(5000);
		source.click();
		searchbox.sendKeys("Pune");
		Thread.sleep(2000);
		System.out.println("List: "+list.size());
		list.get(0).click();
		
		Thread.sleep(5000);
		destination.click();
		Thread.sleep(2000);
		
		searchboxDest.sendKeys("Mumbai");
		Thread.sleep(2000);
		System.out.println("List: "+listDest.size());
		listDest.get(0).click();
		
		date.sendKeys("10/12/2019");
		
		searchBusButton.click();
		
		Thread.sleep(5000);
		return new BusesListPage(driver);
	}
}
