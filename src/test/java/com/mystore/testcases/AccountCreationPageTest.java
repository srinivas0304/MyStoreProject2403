package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystorepageobjects.AccountCreationPage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class AccountCreationPageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage acp;
	
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
	public void verifyAccountPageTest()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		acp=loginPage.createNewAccount("abad@gmail.com");
		boolean res=acp.validateAccountCreatePage();
		Assert.assertTrue(res);
	}
}
