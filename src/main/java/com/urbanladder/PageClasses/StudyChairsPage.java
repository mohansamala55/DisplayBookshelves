package com.urbanladder.PageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.urbanladder.BaseClasses.PageBaseClass;

public class StudyChairsPage extends PageBaseClass {
	WebDriver driver;
	ExtentTest test;

	StudyChairsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	@FindAll(@FindBy(xpath = "//span[@class='name']"))
	public List<WebElement> studychairname;

	@FindAll(@FindBy(xpath = "//div[@class='price-number']/span"))
	public List<WebElement> studychairprice;

	public void studyChairs() {
		threadSleep(2);
		for (int i = 0; i <= 3; i++) {
			System.out.println(studychairname.get(i).getText() + "---" + studychairprice.get(i).getText());
		}
	}
}
