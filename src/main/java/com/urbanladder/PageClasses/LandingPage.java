package com.urbanladder.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	BookShelvesPage bookShelvesPage;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	/**************** Page factory for bookshelves page *************/
	@FindBy(xpath = "//span[@class='header-icon-link user-profile-icon']//*[name()='svg']")
	public WebElement SvgElement;

	@FindBy(xpath = "//a[normalize-space()='Log In']")
	public WebElement LoginOption;

	@FindBy(xpath = "//div[@id='password-credentials']//input[@id='spree_user_email']")
	public WebElement EmailTextbox;

	@FindBy(xpath = "//div[@class='password-wrap']//input[@id='spree_user_password']")
	public WebElement PasswordTextbox;

	@FindBy(xpath = "//input[@id='ul_site_login']")
	public WebElement Loginbtn;

	@FindBy(xpath = "//a[@href='/bookshelf?src=explore_categories']")
	public WebElement BookShelfSvg;

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	public WebElement ProfileOption;

	/**************** Method to do login *************/
	public void doLogin(String userName, String password) {
		//Moving to svg element
		moveTo(SvgElement);
		waitTillElementClickable(LoginOption);
		//Clicking on login option
		LoginOption.click();
		waitTillElementVisible("//div[@id='password-credentials']//input[@id='spree_user_email']");
		//Entering email
		EmailTextbox.sendKeys(userName);
		//Entering password
		PasswordTextbox.sendKeys(password);
		//Clicking on login button
		Loginbtn.click();
		moveTo(SvgElement);
		threadSleep(3);
		// Verifying weather user has successfully logged in

		Assert.assertTrue(ProfileOption.isDisplayed());

	}

	/**************** Method to click on bookshelves svg element *************/
	public BookShelvesPage openSvgElement() {
		scrollByVisiblityOfElement(BookShelfSvg);
		waitTillElementClickable(BookShelfSvg);
		BookShelfSvg.click();

		return PageFactory.initElements(driver, BookShelvesPage.class);
	}

}
