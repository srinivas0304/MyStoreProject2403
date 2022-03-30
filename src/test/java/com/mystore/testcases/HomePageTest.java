package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
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
	public void wishListTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateMyWishList();
//		Assert.assertTrue(res);	
	}
	
	@Test
	public void orderHistoryTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateOrderHistory();
//		Assert.assertTrue(res);
	}
	
}
