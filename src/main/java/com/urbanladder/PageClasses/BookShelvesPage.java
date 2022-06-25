package com.urbanladder.PageClasses;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.urbanladder.BaseClasses.PageBaseClass;

public class BookShelvesPage extends PageBaseClass {

	Actions actions = new Actions(driver);

	@FindBy(xpath = "//div[normalize-space()='Price']")
	public WebElement Price;

	@FindBy(xpath = "//div[@class='noUi-handle noUi-handle-upper']")
	public WebElement sliderHandil;

	@FindBy(xpath = "//div[normalize-space()='Storage Type']")
	public WebElement StorageType;

	@FindBy(xpath = "//input[@id='filters_storage_type_Open']")
	public WebElement CheckBoxOpenType;

	@FindBy(xpath = "//input[@id='filters_storage_type_Open_Storage']")
	public WebElement CheckBoxOpenStorageType;

	@FindBy(xpath = "//input[@id='filters_availability_In_Stock_Only']")
	public WebElement CheckBoxOutOfStock;

	@FindAll(@FindBy(xpath = "//span[@class='name']"))
	public List<WebElement> names;

	@FindAll(@FindBy(xpath = "//div[@class='price-number']/span"))
	public List<WebElement> prices;

	/**************** Method to display bookshelves *************/
	public void toDisplayBookShelves() {

		moveTo(Price);
		threadSleep(2);
		actions.dragAndDropBy(sliderHandil, -199, 0);
		actions.build().perform();
		/***** Feature not available ****/
		/*
		 * actions.moveToElement(StorageType); threadSleep(2); CheckBoxOpenType.click();
		 * CheckBoxOpenStorageType.click();
		 */
		threadSleep(2);
		System.out.println("number : " + names.size());
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i).getText() + "---" + prices.get(i).getText());
		}

	}

}
