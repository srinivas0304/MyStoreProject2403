package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeTest(groups = {"Smoke","Sanity","Regression"})
	public void loadConfig()
	{
		
		try
		{
			prop=new Properties();
			//System.out.println("Super constructor invoked");
			FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\Config\\config.properties");
			prop.load(fs);
		}
		catch(FileNotFoundException a)
		{
			a.printStackTrace();
		}
		catch(IOException b)
		{
			b.printStackTrace();
		}
	}
	
	public  void launchBrowser(String browserName)
	{
		//WebDriverManager.chromedriver().setup();
		//String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Action.imlicitWait(driver, 10);
		driver.get(prop.getProperty("url"));
	}	
}
