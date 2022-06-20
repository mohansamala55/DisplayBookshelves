package com.urbanladder.BaseClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageBaseClass {

	protected WebDriver driver;
	// Thread sleep
	public void threadSleep(int t) {
		try {
			Thread.sleep(t * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// getText
	public void getText(String expected) {
		Assert.assertEquals(expected, driver.getTitle());
	}

}
