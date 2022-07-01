package com.urbanladder.BaseClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class PageBaseClass {
	protected static WebDriver driver;
	Actions actions;

	// Thread sleep
	public void threadSleep(int t) {
		try {
			Thread.sleep(t * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// To move to any element
	public void moveTo(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	// To scroll down the web page by the visibility of the element
	public void scrollByVisiblityOfElement(WebElement scrollToElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollToElement);
	}

	// wait until elementToBeClickable
	public static void waitTillElementClickable(WebElement bookShelfSvg) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(bookShelfSvg));
	}
	
	// wait Till ElementVisible
	public static void waitTillElementVisible(String locater) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locater)));
	}

}
