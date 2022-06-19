package com.urbanladder.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.urbanladder.BaseClasses.BaseClass;
import com.urbanladder.BaseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//span[@class='header-icon-link user-profile-icon']//*[name()='svg']")
	public WebElement svgElement;

	@FindBy(xpath = "//a[normalize-space()='Log In']")
	public WebElement loginOption;

	@FindBy(xpath = "//div[@id='password-credentials']//input[@id='spree_user_email']")
	public WebElement emailTextbox;

	@FindBy(xpath = "//div[@class='password-wrap']//input[@id='spree_user_password']")
	public WebElement passwordTextbox;

	@FindBy(xpath = "//input[@id='ul_site_login']")
	public WebElement loginbtn;

	public void doLogin(String userName, String password) {
		svgElement.click();
		threadSleep(2);
		loginOption.click();
		threadSleep(5);
		emailTextbox.sendKeys(userName);
		passwordTextbox.sendKeys(password);
		loginbtn.click();
	}

}
