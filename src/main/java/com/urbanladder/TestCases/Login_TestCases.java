package com.urbanladder.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.BaseClasses.PageBaseClass;
import com.urbanladder.PageClasses.LandingPage;

public class Login_TestCases extends BaseClass {


	LandingPage landingpage;

	@Test
	public void test1() {

		invokeBrowser("chrome");
		landingpage=openWedsite();
		landingpage.doLogin("awesomemohan143@gmail.com","Mohanraj100000$");
		quitBrowser();
		
		
	}


}
