package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	@FindBy(xpath="//div[@class='product-image-container']//img[@title='Faded Short Sleeve T-shirts']")
	WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		Action.click(driver, productResult,"//div[@class='product-image-container']//img[@title='Faded Short Sleeve T-shirts']");
		return new AddToCartPage();
	}
}
