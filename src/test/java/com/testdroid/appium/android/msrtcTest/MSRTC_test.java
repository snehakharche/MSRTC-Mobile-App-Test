package com.testdroid.appium.android.msrtcTest;

import org.testng.annotations.Test;

import com.testdroid.appium.android.msrtc.PageObject.SelectBusPage;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;


import org.testng.annotations.AfterClass;

public class MSRTC_test {
  @Test
  public void Test() throws MalformedURLException, InterruptedException {
	  
	 SelectBusPage s = new SelectBusPage();
	 s.selectBus().getLoggedIn().searchBus().selectBusFromList().selectSeat().Proceed();
	
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
