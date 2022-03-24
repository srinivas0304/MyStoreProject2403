package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass
{
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id="email_create")
	WebElement emailForNewAccount;
	
	@FindBy(xpath="//i[@class='icon-user left']")
	WebElement createNewAccountBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String username1, String password1)
	{
//		username.sendKeys(uname);
//		password.sendKeys(pass);
//		submitBtn.click();
		Action.type(username, username1);
		Action.type(password, password1);
		Action.click(driver, signInBtn);
		return new HomePage();
	}
	
	public AddressPage login1(String username1, String password1)
	{
	Action.type(username, username1);
	Action.type(password, password1);
	Action.click(driver, signInBtn);
	return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newMail)
	{
		Action.type(emailForNewAccount, newMail);
		Action.click(driver, createNewAccountBtn);
		return new AccountCreationPage();
	}
}
