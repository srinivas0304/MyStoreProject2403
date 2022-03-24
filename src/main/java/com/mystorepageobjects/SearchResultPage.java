package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	@FindBy(xpath="//div[@id='center_column']")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		Action.click(driver, productResult);
		return new AddToCartPage();
	}
}
