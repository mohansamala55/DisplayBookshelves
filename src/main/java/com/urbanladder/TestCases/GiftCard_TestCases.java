package com.urbanladder.TestCases;

import org.testng.annotations.Test;

import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.GiftCardsPage;
import com.urbanladder.PageClasses.LandingPage;

public class GiftCard_TestCases extends BaseClass {
	
	LandingPage landingpage;
	GiftCardsPage giftcardspage;
	@Test
	public void giftCardTestcase() {
		
		invokeBrowser("chrome");
		openWedsite();
		landingpage.doLogin("namrata@gmail.com","Nam12356*");
		giftcardspage=landingpage.giftcards();
		quitBrowser();
	}
	
	

	
	
}
