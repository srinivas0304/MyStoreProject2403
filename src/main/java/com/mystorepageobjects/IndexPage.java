package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass
{
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement myStorelogo;
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement submitBtn;
	
	
	public IndexPage()//constructor to initilization the values for above elements
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSign() 
	{
		//signInBtn.click();
		Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		//System.out.println("verify logo");
		return Action.isDisplayed(driver, myStorelogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStroreTitle=driver.getTitle();
		return myStroreTitle;
	}
	
	public SearchResultPage searchProduct(String producyName)
	{
		Action.type(searchBox, producyName);
		Action.click(driver, submitBtn);
		return new SearchResultPage();
	}
	
	
	
}
