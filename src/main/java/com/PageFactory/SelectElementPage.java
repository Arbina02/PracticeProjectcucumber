package com.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SelectElementPage {

	public WebDriver driver;
	
	private By radiobutton=By.xpath("//input[@id='bmwradio']");
	private By selectDropdown=By.xpath("//select[@id='carselect']");
    private	By multipleDropdown=By.xpath("//select[@id='multiple-select-example']/option");
	private By checkBox=By.id("benzcheck");
	
	public SelectElementPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void getradioFunction()
	{
		driver.findElement(radiobutton).click();
	}
	
	public void getselectdrop()
	{
		WebElement Lists=driver.findElement(selectDropdown);
		Select select=new Select(Lists);
		select.selectByIndex(1);
	}
	
	public void getMultipleDropdown()
	{
		List<WebElement> dropdown=driver.findElements(multipleDropdown);
		for(int i=0; i<dropdown.size()-1; i++)
		{
			if(dropdown.get(i).getText().contains("Peach"))
			{
				dropdown.get(i).click();
				break;
			}
		}
	}
	
	public void getCheckbox()
	{
		driver.findElement(checkBox).click();
	}
	
	
	
}
