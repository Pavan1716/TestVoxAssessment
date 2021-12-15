package com.testvox.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class UdemyHomePage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public UdemyHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name='q']")
	public WebElement searchBox;

//Assertion for Google Page
	public void verifyGoogle() {
		String googleTile = driver.getTitle();
		System.out.println(googleTile);
		Assert.assertEquals(googleTile, "Google");
	}

	// Enter Test Automation Learning in google search and get the title of result
	public void searchBox() {
		searchBox.sendKeys("Test Automation Learning");
		searchBox.sendKeys(Keys.ENTER);
		String testAutomatin = driver.getTitle();
		System.out.println(testAutomatin);

	}

}