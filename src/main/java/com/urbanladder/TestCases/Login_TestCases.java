package com.urbanladder.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.LandingPage;

import utilities.XLUtility;

public class Login_TestCases extends BaseClass {

	LandingPage landingpage;

	@Test(dataProvider = "LoginData")
	public void Login_Test(String Username, String Password, String Exp_Result) {

		test = extent.createTest("Login test");

		invokeBrowser("chrome");
		landingpage = openWedsite();
		landingpage.moveToSVGElement();
		landingpage.clickLoginOption();
		landingpage.enterEmail_login(Username);
		landingpage.enterPassword_login(Password);
		landingpage.clickLoginbtn();

		if (Exp_Result.equalsIgnoreCase("Valid")) {
			if (landingpage.verifyLoginOrSignup() == true) {
				landingpage.logout();
				Assert.assertTrue(true);
				quitBrowser();
			} else {
				Assert.assertTrue(false);
				quitBrowser();
			}
		} else if (Exp_Result.equalsIgnoreCase("Invalid")) {
			if (landingpage.verifyLoginOrSignup() == false) {
				Assert.assertTrue(true);
			} else {
				landingpage.logout();
				Assert.assertTrue(false);
			}
		}
		quitBrowser();
	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {

		String path = "C:\\Users\\mohan\\Desktop\\DisplayBookShelves\\TestCaseData\\TestData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("Login_data");
		int totalcols = xlutil.getCellCount("Login_data", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int r = 1; r <= totalrows; r++) {

			for (int c = 0; c < totalcols; c++) {
				loginData[r - 1][c] = xlutil.getCellData("Login_data", r, c);
			}
		}

		return loginData;
	}

}
