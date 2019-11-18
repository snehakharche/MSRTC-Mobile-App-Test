package com.testdroid.appium.android.msrtc.bitbarcapability;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BitbarCapability {
	
	public static AndroidDriver<AndroidElement> Capability() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		File f = new File("resources");
		File fs = new File(f, "MSRTC_1.19.apk");
		
		
		//bitbar
	
		
		cap.setCapability( "platformName", "Android");
		
		cap.setCapability("automationName", System.getenv("AUTOMATION_NAME"));
		
		cap.setCapability("deviceName", "Android Device");
		cap.setCapability("appPackage", "com.expscs.msrtc");
		cap.setCapability("appActivity","com.expscs.msrtc.SplashActivity");
		cap.setCapability("appium:autoGrantPermissions", "true");
		
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),cap);
		
		
		return driver;
	}
	
	
}
