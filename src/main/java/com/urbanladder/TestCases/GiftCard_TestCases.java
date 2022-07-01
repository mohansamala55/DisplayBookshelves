package com.urbanladder.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.GiftCardsPage;
import com.urbanladder.PageClasses.LandingPage;

/*
 * @author Namratha Jambaladinni (2164735);
 */
public class GiftCard_TestCases extends BaseClass {
	LandingPage landingpage;
	GiftCardsPage giftcardspage;

	@Test
	public void giftCardTestcase() throws IOException {
		test = extent.createTest("Gift cards test case");
		invokeBrowser("chrome");
		landingpage = openWedsite();
		landingpage.doLogin("namrata@gmail.com", "Nam12356*");
		giftcardspage = landingpage.opengiftCards();
		giftcardspage.giftcards();
		getScreenshot(driver, "GiftCards_Error");
		Assert.assertTrue(false);
		test.log(Status.FAIL, "Error message captured successfully");
	}

}
