package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass
{
	@FindBy(id="uniform-cgv")
	WebElement checkOut;
	
	@FindBy(xpath="(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement proceedToCheckOutBtn;
	
	public ShippingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms()
	{
		Action.click(driver, checkOut);
	}
	public PaymentPage clickOnCheckBox()
	{
		Action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}
	
}
