package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass
{
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	WebElement payByBankWire;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	WebElement payByCheck;
	
	public PaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public OrderSummaryPage clickOnPayment()
	{
		Action.click(driver, payByBankWire);
		return new OrderSummaryPage();
	}
	
	
	
}
