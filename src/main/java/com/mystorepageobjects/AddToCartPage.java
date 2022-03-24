package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//div[@class='clearfix']//div//h2//i")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCart;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity1)
	{
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1, size);
	}
	
	public boolean clickOnAddToCart()
	{
		return Action.isDisplayed(driver, addToCartMessage);
	}
	
	public void proceedToCheckOut() throws Exception
	{
		Action.JSClick(driver, addToCart);
	}
	
}
