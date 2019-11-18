package com.testdroid.appium.android.msrtc.PageObject;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	WebDriverWait wait;
	
	@CacheLookup
	@AndroidFindBy(id="edtUsername")
	AndroidElement username;
	
	@CacheLookup
	@AndroidFindBy(id="edtPassword")
	AndroidElement password;
	
	@CacheLookup
	@AndroidFindBy(id="btnLogin")
	AndroidElement loginButton;
	
	public LoginPage(AndroidDriver<AndroidElement> driver) throws MalformedURLException {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		wait = new WebDriverWait(this.driver, 20);
	}
	
	public SearchBuses getLoggedIn() throws MalformedURLException, InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("edtUsername")));
		
		username.sendKeys("SnehaBK123");
		password.sendKeys("SnehaBK");
		
		loginButton.click();
		return new SearchBuses(driver);
	}
}
