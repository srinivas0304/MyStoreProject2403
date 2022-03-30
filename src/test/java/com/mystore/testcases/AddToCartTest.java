package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.SearchResultPage;

public class AddToCartTest extends BaseClass
{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCart;
	
@Parameters("browser")
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser)
	{
		launchBrowser(browser);
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(groups = {"Regression","Sanity"})
	public void addToCart() throws Exception
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("shirt");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickOnAddToCart();
		boolean res=addToCart.validateAddToCart();
		Assert.assertTrue(res);
	}
}
