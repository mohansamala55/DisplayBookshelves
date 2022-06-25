package com.urbanladder.TestCases;

import org.testng.annotations.Test;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.BookShelvesPage;
import com.urbanladder.PageClasses.LandingPage;

public class BookShelves_TestCases extends BaseClass {

	LandingPage landingpage;
	BookShelvesPage bookShelvePage;

	@Test
	public void displayBookShelves() {
		// invoking browser
		invokeBrowser("chrome");
		// Opening website
		landingpage = openWedsite();
		// Doing login
		landingpage.doLogin("awesomemohan143@gmail.com", "Mohanraj100000$");
		// Opening bookshelves page
		bookShelvePage = landingpage.openSvgElement();
		// Displaying bookshelves
		bookShelvePage.toDisplayBookShelves();

		// closing browser
		quitBrowser();
	}

}
