package com.mystore.extentReport;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.AddressPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.OrderConfirmationPage;
import com.mystorepageobjects.OrderPage;
import com.mystorepageobjects.OrderSummaryPage;
import com.mystorepageobjects.PaymentPage;
import com.mystorepageobjects.SearchResultPage;
import com.mystorepageobjects.ShippingPage;

public class EndToEndTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCart;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	@BeforeSuite
	public void setUpExtentReport() 
	{
		
	htmlReporter = new ExtentHtmlReporter("./ExtentReports/EndToEnd.html");
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	}
	
	@BeforeMethod
	public void setup()
	{
		launchBrowser();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test
	public void endToEndTest() throws Throwable
	{
		ExtentTest test = extent.createTest("FirstTestcase");
		
		test.log(Status.INFO, "FirstTestcase");
		test.log(Status.PASS, "FirstTestcase");

		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("shirt");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickOnAddToCart();
		orderPage=addToCart.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickToCheckOut();
		shippingPage.clickOnCheckBox();
		paymentPage=shippingPage.clickOnCheckoutBtn();
		orderSummaryPage=paymentPage.clickOnPayment();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrder();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
		@AfterSuite
		public void flush() 
		{
		extent.flush();
		}
	
}
