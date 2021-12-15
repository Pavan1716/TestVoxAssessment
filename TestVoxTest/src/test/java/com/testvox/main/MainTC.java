package com.testvox.main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.testvox.pages.AmazonHomePage;
import com.testvox.pages.CartPage;
import com.testvox.pages.ItemPage;
import com.testvox.pages.LinksPage;
import com.testvox.pages.ProductsPage;
import com.testvox.pages.UdemyHomePage;
import com.testvox.pages.UdemySitePage;

public class MainTC {

	static WebDriver driver;

	@Test
	public void Amazon() throws Exception {
		// Browser Initialization
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");

		// Instantiating Login & Profile page using initElements()
		AmazonHomePage obj = PageFactory.initElements(driver, AmazonHomePage.class);
		ProductsPage prod = PageFactory.initElements(driver, ProductsPage.class);
		ItemPage item = PageFactory.initElements(driver, ItemPage.class);
		CartPage cart = PageFactory.initElements(driver, CartPage.class);

		// Using the methods created in pages class to perform actions
		obj.searchProducts();
		prod.verifyAmazonBasic();
		prod.ourBrands();
		prod.crossCutPaper();
		item.verifyCrossCutPaper();
		item.verifyEightSheet();
		item.addtoCartButton();
		item.cartClick();
		cart.verifyCart();
		cart.cartCount();
		driver.quit();
	}

	@Test
	public void GoogleSearch() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Instantiating Login & Profile page using initElements()
		UdemyHomePage home = PageFactory.initElements(driver, UdemyHomePage.class);
		LinksPage link = PageFactory.initElements(driver, LinksPage.class);
		UdemySitePage udemy = PageFactory.initElements(driver, UdemySitePage.class);

		// Using the methods created in pages class to perform actions
		home.verifyGoogle();
		home.searchBox();
		link.clickUdemyLink();
		udemy.verifyUdemy();
		udemy.searchBDD();
		driver.quit();
	}

}