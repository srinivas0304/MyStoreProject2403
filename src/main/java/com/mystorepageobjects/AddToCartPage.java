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
	WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
	WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOutBtn;
	
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
	
	public void clickOnAddToCart() throws InterruptedException
	{
		Action.click(driver, addToCartBtn,"//span[text()='Add to cart']");
	}
	public boolean validateAddToCart() throws InterruptedException
	{
		Action.fluentWait(driver, addToCartMessage, 10);
		return Action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() throws Exception
	{
		Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		Action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
