package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	@FindBy(xpath="//li[@class='lnk_wishlist']//span")
	WebElement myWishList;
	
	@FindBy(xpath="//a[@title='Orders']//span")
	WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList()
	{
		Action.fluentWait(driver, myWishList, 10);
		return Action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory()
	{
		return Action.isDisplayed(driver, orderHistory);
	}
	
//	public String getCurrentUrl()
//	{
//		String homePageUrl=driver.getCurrentUrl();
//		return homePageUrl;
//	}
}
