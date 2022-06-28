package com.urbanladder.BaseClasses;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.urbanladder.PageClasses.LandingPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver;
	LandingPage landingpage;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

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
		// return PageFactory.initElements(driver, LandingPage.class);
		LandingPage landingpage = new LandingPage(driver, test);
		PageFactory.initElements(driver, landingpage);
		return landingpage;
	}

	/**************** Closing browser *************/
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}

	/**************** This method will run before all the tests *************/
	@BeforeTest
	public void setExtent() {
		// Specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\test-output\\my-report.html");

		htmlReporter.config().setDocumentTitle("Automation Report");// Title of report
		htmlReporter.config().setReportName("Functional Testing");// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		// Attaching above created extent report to this report object
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("OS", "windows");
		extent.setSystemInfo("Environment", "QA");

	}

	/**************** This method will run after all the tests *************/
	@AfterTest
	public void endReport() {
		extent.flush();
	}

	/**************** This method will run after each test method *************/

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
			// to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());
			// to add error/exception in extent report
			String screenshotPath = BaseClass.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
			// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "The Case SKIPPED is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "The Case PASSED is " + result.getName());
		}

	}

	/**************** Method to take screen short *************/
	private static String getScreenshot(WebDriver driver, String name) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
}
