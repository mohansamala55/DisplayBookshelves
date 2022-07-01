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

/*
 * @author Nikilesh Kumar (2165019);
 */
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
		landingpage.verifyLoginOrSignup();
		
			if (Exp_Result.equalsIgnoreCase("Valid")) {
				if (landingpage.verifyLoginOrSignup() == "Pass") {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			} else if (Exp_Result.equalsIgnoreCase("Invalid")) {
				if (landingpage.verifyLoginOrSignup() == "Fail") {
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
		} 


	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\TestCaseData\\TestData.xlsx";
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
