package com.urbanladder.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.urbanladder.BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	BookShelvesPage bookShelvesPage;
	ExtentTest test;

	public LandingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/**************** Page factory for bookshelves page *************/
	@FindBy(xpath = "//span[@class='header-icon-link user-profile-icon']//*[name()='svg']")
	public WebElement SvgElement;

	@FindBy(xpath = "//a[normalize-space()='Log In']")
	public WebElement LoginOption;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	public WebElement SignUpOption;

	@FindBy(xpath = "//div[@id='password-credentials']//input[@id='spree_user_email']")
	public WebElement EmailTextbox_login;

	@FindBy(xpath = "//form[@id='signup_form']//input[@id='spree_user_email']")
	public WebElement EmailTextbox_signup;

	@FindBy(xpath = "//div[@class='password-wrap']//input[@id='spree_user_password']")
	public WebElement PasswordTextbox_login;

	@FindBy(xpath = "(//input[@placeholder='Password*'])[2]")
	public WebElement PasswordTextbox_signup;

	@FindBy(xpath = "//input[@id='ul_site_login']")
	public WebElement Loginbtn;

	@FindBy(xpath = "//input[@value='Sign Up']")
	public WebElement SignUpbtn;

	@FindBy(xpath = "//a[@href='/bookshelf?src=explore_categories']")
	public WebElement BookShelfSvg;

	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div/section[3]/ul/li[2]/span/ul/li[1]/a")
	public WebElement ProfileOption;
	
	@FindBy(xpath = "//a[@id='logout']")
	public WebElement Logoutbtn;
	
	@FindBy(xpath="//div[normalize-space()='The email or password you entered is incorrect. Please try again.']")
	public WebElement errorMsg;
	
	/**************** Method to do login *************/
	public void doLogin(String userName, String password) {
		// Moving to svg element
		moveTo(SvgElement);
		waitTillElementClickable(LoginOption);
		// Clicking on login option
		LoginOption.click();
		waitTillElementVisible("//div[@id='password-credentials']//input[@id='spree_user_email']");
		test.log(Status.PASS, "Login option clicked sueecssfully");
		// Entering email
		EmailTextbox_login.sendKeys(userName);
		// Entering password
		PasswordTextbox_login.sendKeys(password);
		// Clicking on login button
		Loginbtn.click();
		moveTo(SvgElement);
		threadSleep(3);
		// Verifying weather user has successfully logged in

		Assert.assertTrue(ProfileOption.isDisplayed());
		test.log(Status.PASS, "User logged in successfully");

	}
	public GiftCardsPage loginforgiftcard() {
		moveTo(SvgElement);
		waitTillElementClickable(LoginOption);
		LoginOption.click();
		waitTillElementVisible("//div[@id='password-credentials']//input[@id='spree_user_email']");
		test.log(Status.PASS, "Login option clicked sueecssfully");
		EmailTextbox_login.sendKeys("Namrata@gmail.com");
		PasswordTextbox_login.sendKeys("Nam123456*");
		Loginbtn.click();
		GiftCardsPage giftcardpage = new GiftCardsPage(driver, test);
		PageFactory.initElements(driver,giftcardpage );
		return giftcardpage;
	
		
		
	}

	/**************** Method to click on bookshelves svg element *************/
	public BookShelvesPage openSvgElement() {
		scrollByVisiblityOfElement(BookShelfSvg);
		waitTillElementClickable(BookShelfSvg);
		BookShelfSvg.click();
		test.log(Status.PASS, "Bookshelves SVG element clicked successfully");

		BookShelvesPage bookshelvespage = new BookShelvesPage(driver, test);
		PageFactory.initElements(driver, bookshelvespage);
		return bookshelvespage;
		// return PageFactory.initElements(driver, BookShelvesPage.class);
	}

	/****** Login test method's ***************/
	public void moveToSVGElement() {
		moveTo(SvgElement);
		waitTillElementClickable(LoginOption);
	}

	public void clickLoginOption() {
		LoginOption.click();
		waitTillElementVisible("//div[@id='password-credentials']//input[@id='spree_user_email']");
	}

	public void enterEmail_login(String username) {
		EmailTextbox_login.clear();
		EmailTextbox_login.sendKeys(username);
	}

	public void enterPassword_login(String password) {
		PasswordTextbox_login.clear();
		PasswordTextbox_login.sendKeys(password);
	}

	public void clickLoginbtn() {
		Loginbtn.click();
	}

	/****** SignUp test method's ***************/

	public void clickSignupOption() {
		SignUpOption.click();
		waitTillElementVisible("//form[@id='signup_form']//input[@id='spree_user_email']");
	}

	public void enterEmail_signup(String username) {
		EmailTextbox_signup.clear();
		EmailTextbox_signup.sendKeys(username);
	}

	public void enterPassword_signup(String password) {
		PasswordTextbox_signup.clear();
		PasswordTextbox_signup.sendKeys(password);
	}

	public void clickSignupbtn() {
		SignUpbtn.click();
	}

	/****** Method to check user signed successfully ***************/
	public boolean verifyLoginOrSignup() {
		moveTo(SvgElement);
		threadSleep(3);
		if (LoginOption.isDisplayed()) {
			return false;
		}else {
			return true;
		}
	}

	/****** Method to Logout ***************/
	public void logout() {
		moveTo(SvgElement);
		threadSleep(3);
		Logoutbtn.click();
	}
}
