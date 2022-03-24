package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class LoginPageTest extends BaseClass
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
	public void loginTest() throws Exception
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String actualUrl=homePage.getCurrentUrl();
		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actualUrl, expectedUrl);	
	}
}
