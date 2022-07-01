package com.urbanladder.PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.BaseClasses.PageBaseClass;

public class GiftCardsPage extends PageBaseClass {
	ExtentTest test;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[1]/ul/li[3]/div/div/p")
	public WebElement birthdayCard;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/div[1]/button[2]")
	public WebElement giftcardPrice;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[2]/div/section[2]/button")
	public WebElement giftcardNextoption;

	@FindBy(xpath = "/html/body/div[1]/div/main/section/section[3]/form/div[1]/fieldset[1]/div[1]/input")
	public WebElement recipientName;

	@FindBy(xpath = "//*[@id=\"ip_137656023\"]")
	public WebElement recipientEmail;

	@FindBy(xpath = "//*[@id=\"ip_1082986083\"]")
	public WebElement yourName;

	@FindBy(xpath = "//*[@id=\"ip_4081352456\"]")
	public WebElement yourEmail;

	@FindBy(xpath = "//*[@id=\"ip_2121573464\"]")
	public WebElement yourMobile;

	@FindBy(xpath = "//*[@id=\"app-container\"]/div/main/section/section[3]/form/button")
	public WebElement confirmBTN;

	@FindBy(xpath = "//h1[normalize-space()='Gift Cards']")
	public WebElement gificardHeader;

	public GiftCardsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void giftcards() {
		scrollByVisiblityOfElement(gificardHeader);
		waitTillElementClickable(birthdayCard);
		birthdayCard.click();
		waitTillElementClickable(giftcardPrice);
		giftcardPrice.click();
		threadSleep(2);
		giftcardNextoption.click();
		recipientName.sendKeys("Namrata");
		recipientEmail.sendKeys("namrata@gmail.com");
		// yourName.sendKeys("");
		yourEmail.sendKeys("Jyoti@gmail.com");
		yourMobile.sendKeys("912765458");
		confirmBTN.click();
	}

}
