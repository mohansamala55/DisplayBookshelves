package com.urbanladder.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.LandingPage;
import utilities.XLUtility;

/*
 * @author Kandagiri Samhitha (2163963);
 */
public class SignUp_TestCases extends BaseClass {
	LandingPage landingpage;

	@Test(dataProvider = "SignUpData")
	public void SignUpTestCase(String Username, String Password, String Exp_Result) {
		test = extent.createTest("SignUpF test");
		invokeBrowser("chrome");
		landingpage = openWedsite();
		landingpage.moveToSVGElement();
		landingpage.clickSignupOption();
		landingpage.enterEmail_signup(Username);
		landingpage.enterPassword_signup(Password);
		landingpage.clickSignupbtn();
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
	

	@DataProvider(name = "SignUpData")
	public String[][] getData() throws IOException {
		String path = ".\\TestCaseData\\TestData.xlsx";
		XLUtility xlutil = new XLUtility(path);

		int totalrows = xlutil.getRowCount("Signup_data");
		int totalcols = xlutil.getCellCount("Signup_data", 1);

		String signupData[][] = new String[totalrows][totalcols];
		for (int r = 1; r <= totalrows; r++) {

			for (int c = 0; c < totalcols; c++) {
				signupData[r - 1][c] = xlutil.getCellData("Signup_data", r, c);
			}
		}
		return signupData;
	}
}
