package com.testvox.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LinksPage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public LinksPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h3[text()='Top Automation Testing Courses Online - Udemy']")
	public WebElement link;

	// Click on Udemy Link
	public void clickUdemyLink() {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		link.click();

	}
}
