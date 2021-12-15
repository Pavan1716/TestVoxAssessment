package com.testvox.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductsPage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Our Brands']/parent::a/div/label/i")
	public WebElement ourBrandsChkBox;

	@FindBy(xpath = "//span[text()='Our Brands']")
	public WebElement ourBrands;

	@FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
	public WebElement verifyAmazonBasic;

	@FindBy(xpath = "//span[text()='Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon']")
	public WebElement crossCutPaper;

	public void ourBrands() throws Exception {
		// javascriptExecutor for scroll and click
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ourBrands);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();", ourBrandsChkBox);

	}

	// Method for removing characters in string at perticular position
	public static String charRemoveAt(String amount, int p) {
		return amount.substring(0, p) + amount.substring(p + 1);
	}

	public void verifyAmazonBasic() {
		String basic = verifyAmazonBasic.getText();
		System.out.println(basic);
		String str = charRemoveAt(basic, 0);
		System.out.println(str);
		String str1 = charRemoveAt(str, 13);
		System.out.println(str1);
		// Assertion for search of Amazon Basics
		Assert.assertEquals(str1, "Amazon Basics");

	}

	public void crossCutPaper() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", crossCutPaper);
		js.executeScript("arguments[0].click();", crossCutPaper);
	}

}
