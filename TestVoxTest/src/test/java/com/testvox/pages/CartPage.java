package com.testvox.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CartPage {

	final WebDriver driver;

	// Constructor, as every page needs a Webdriver to find elements
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//h1")
	public WebElement shoppingCart;

	@FindBy(xpath = "(//span[text()='Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon'])[2]")
	public WebElement textEightSheetinCart;

	@FindBy(xpath = "//span[@id='nav-cart-count']")
	public WebElement cartCount;

	// Assertion for product is present in cart page
	public void verifyCart() {
		if (shoppingCart.isDisplayed()) {
			String nameProduct = textEightSheetinCart.getText();
			System.out.println(nameProduct);
			Assert.assertEquals(nameProduct,
					"Amazon Basics 8-Sheet Capacity, Cross-Cut Paper and Credit Card Shredder, 4.1 Gallon");
			System.out.println("Item added successfully in Cart");
		}
	}

	// Assertion for cart count
	public void cartCount() {
		String count = cartCount.getText();
		System.out.println(count);
		Assert.assertEquals(count, "1");
		System.out.println("Cart shows count as 1");
	}
}
