package com.testvox.pages;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class UdemySitePage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public UdemySitePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='q']")
	public WebElement searchBox;
	
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


	// Verify Udemy Page using Assertion
	public void verifyUdemy() {
		String titleUdemy = driver.getTitle();
		System.out.println(titleUdemy);
		if (titleUdemy.equalsIgnoreCase("udemy")) {
			Assert.assertTrue(true);
		}
	}

	// Enter BDD with cucumber in search box
	public void searchBDD() throws Exception {
		searchBox.sendKeys("BDD with Cucumber");
		searchBox.sendKeys(Keys.ENTER);
		ScreenShot("CaptchaOrReload");
		System.out.println("Page is asking for captha sometimes and page is not loaded sometimes");

	}
}
