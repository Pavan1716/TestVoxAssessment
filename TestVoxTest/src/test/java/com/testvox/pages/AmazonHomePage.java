package com.testvox.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AmazonHomePage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(id = "twotabsearchtextbox")
	public WebElement searchAmazonBasic;

	//Search for product
	public void searchProducts() {

		searchAmazonBasic.sendKeys("Amazon Basics");
		searchAmazonBasic.sendKeys(Keys.ENTER);

	}

}
