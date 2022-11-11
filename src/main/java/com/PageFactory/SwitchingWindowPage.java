package com.PageFactory;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchingWindowPage
{
	public WebDriver driver;

	private By switchWinodw=By.xpath("//button[@class='btn-style class1']");
	private By searchData=By.xpath("//input[@id='search']");
	private By button=By.xpath("//button[@class='find-course search-course']");
	private By switchTab=By.xpath("//a[@class='btn-style class1 class2']");
	private By alertBox=By.xpath("//input[@name='enter-name']");
	private By alertAccept=By.xpath("//input[@id='alertbtn']");
	private By alertCancel=By.xpath("//input[@id='confirmbtn']");


	public SwitchingWindowPage(WebDriver driver)
	{
		this.driver=driver;
	}


	public void getWindow()
	{
		driver.findElement(switchWinodw).click();
	}
	
	public void getChildwidow()
	{
		String parent=driver.getWindowHandle();
		Set<String> allwindow=driver.getWindowHandles();
		Iterator<String> itr=allwindow.iterator();
		while(itr.hasNext())
		{
			String child=itr.next();
			if(!parent.equals(child))
			{
				driver.switchTo().window(child);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				driver.findElement(searchData).sendKeys("JavaScript for beginners");
				driver.findElement(button).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parent);
			System.out.println(driver.getTitle());
		}
	}

	public void getTab()
	{
		driver.findElement(switchTab).click();
		
	}
	public void getChildTab()
	{
		String parentwindow=driver.getWindowHandle();
		Set<String> allwindow=driver.getWindowHandles();
		Iterator<String> itr=allwindow.iterator();
		while(itr.hasNext())
		{
			String childwindow=itr.next();
			if(!parentwindow.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				driver.manage().window().maximize();
				System.out.println(driver.getTitle());
				driver.findElement(searchData).sendKeys("JavaScript for beginners");
				driver.findElement(button).click();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.close();
			}
			driver.switchTo().window(parentwindow);
			System.out.println(driver.getTitle());
		}
	}

	public void getAlertAccept()
	{
		driver.findElement(alertAccept).click();
		driver.switchTo().alert().getText();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}

	public void getAlertDismiss()
	{
		driver.findElement(alertCancel).click();
		driver.switchTo().alert().getText();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();
	}

	public void getAlertsend()
	{
		driver.findElement(alertBox).sendKeys("Handle alert");
		driver.findElement(alertCancel).click();
		driver.switchTo().alert().getText();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().dismiss();		
	}
}
