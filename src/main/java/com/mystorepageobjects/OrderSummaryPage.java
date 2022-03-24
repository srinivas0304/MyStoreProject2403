package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderSummaryPage extends BaseClass
{
	@FindBy(xpath="//span[text()='I confirm my order']")
	WebElement confirmOrderBtn;
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmationPage clickOnConfirmOrder()
	{
		Action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
}
