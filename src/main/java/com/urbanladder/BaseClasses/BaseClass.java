package com.urbanladder.BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.PageClasses.LandingPage;

import utilities.ExtentReportManager;

public class BaseClass {

	public WebDriver driver;
	LandingPage landingpage;

	/*************** Invoking browser *************/
	public void invokeBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
	}

	/**************** Opening website *************/
	public LandingPage openWedsite() {
		driver.get("https://www.urbanladder.com/");
		driver.manage().window().maximize();
		return PageFactory.initElements(driver, LandingPage.class);
	}

	/**************** Closing browser *************/
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

}
