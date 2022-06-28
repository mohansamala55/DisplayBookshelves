package com.urbanladder.TestCases;

import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.PageClasses.BookShelvesPage;
import com.urbanladder.PageClasses.LandingPage;

public class BookShelves_TestCases extends BaseClass {

	LandingPage landingpage;
	BookShelvesPage bookShelvePage;

	@Test
	public void displayBookShelves() {
		test = extent.createTest("Displaying Bookshelves-TestCase");
		// invoking browser
		test.log(Status.INFO, "Opening browser");
		invokeBrowser("chrome");
		// Opening URL
		landingpage = openWedsite();
		test.log(Status.PASS, "URL opened successfully");
		// Doing login
		landingpage.doLogin("awesomemohan143@gmail.com", "Mohanraj100000$");
		// Opening bookshelves page
		bookShelvePage = landingpage.openSvgElement();
		// Displaying bookshelves
		bookShelvePage.toDisplayBookShelves();
		test.log(Status.PASS, "Book shelves displayed successfully");

	}

}
