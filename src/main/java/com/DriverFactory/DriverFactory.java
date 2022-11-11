package com.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	
	 public static ThreadLocal<WebDriver> ldriver=new ThreadLocal<>();
	
	public WebDriver init_browser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
		    ldriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			ldriver.set(new FirefoxDriver());
		}else if(browser.equalsIgnoreCase("safari"))
		{
			ldriver.set(new SafariDriver());
		}else {
			System.out.println("Please pass valid browser:"+ browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();	
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return ldriver.get();
	}
}
