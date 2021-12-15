package com.testvox.pages;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ItemPage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "(//span[text()='8 Sheet'])[1]")
	public WebElement eightSheet;

	@FindBy(id = "add-to-cart-button")
	public WebElement addtoCartButton;

	@FindBy(xpath = "//span[text()=' Cart ']")
	public WebElement cartClick;

	@FindBy(xpath = "//div[@id='nav-cart-text-container']/span[2]")
	public WebElement cartView;

	// Method for Explicit Wait
	public void waitUntilElementVisibleLocated(WebElement ele, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	// Method for Taking Screenshot with exact time and date
	public void ScreenShot(String name) throws Exception {
		DateFormat dateformat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		String date1 = dateformat.format(date);
		System.out.println(date1);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./ScreenShots/" + name + "" + date1 + ".png"));
	}

	// Verify the driver is in product page
	public void verifyCrossCutPaper() {

		String crossCutTitle = driver.getTitle();
		System.out.println(crossCutTitle);
		Assert.assertEquals(crossCutTitle,
				"Amazon.com : Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon : Office Products");
	}

//Assertion for selecting 8 sheets for product
	public void verifyEightSheet() throws Exception {

		String eightSheetText = eightSheet.getText();
		Assert.assertEquals(eightSheetText, "8 Sheet");
		ScreenShot("8 Sheet");

	}

	// Clicking add to cart Button
	public void addtoCartButton() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addtoCartButton);
		Thread.sleep(3000);
	}

	public void cartClick() {
		waitUntilElementVisibleLocated(cartClick, 30); // usage of Explicit wait
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cartClick);
		cartView.click();

	}
}
