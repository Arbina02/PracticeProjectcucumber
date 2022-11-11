package com.PageFactory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WindowPage {


	public WebDriver driver;

	private By rowElement=By.xpath("//table/tbody/tr");
	private By colElement=By.xpath("//table/tbody/tr[2]/td");
	private By hiddenButton=By.xpath("//input[@id='hide-textbox']");
	private By showButton=By.xpath("//input[@id='show-textbox']");
	private By mouseHover=By.xpath("//div[@class='mouse-hover']/button");
	private By topButton=By.xpath("//div[@class='mouse-hover-content']/child::a[1]");
	private By reloadButton=By.xpath("//div[@class='mouse-hover-content']/child::a[2]");
	

	public WindowPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void getTableElement() throws InterruptedException
	{
		List<WebElement> rowcount=driver.findElements(rowElement);
		int rowsize=rowcount.size();
		List<WebElement> colcount=driver.findElements(colElement);
		int colsize=colcount.size();
		for(int i=2; i<=rowsize; i++)
		{
			for(int j=2; j<=colsize; j++)
			{
				System.out.print(driver.findElement(By.xpath("//table/tbody/tr["+ i +"]/td["+ j +"]")).getText()+" ");
				Thread.sleep(3000);
			}
			System.out.println();
		}	
	}


	public void gethiddenButton()
	{
		driver.findElement(hiddenButton).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementById('displayed-text').value='Arun Motori';");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void getShowButton()
	{
		driver.findElement(showButton).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void getMouse()
	{
		WebElement element=driver.findElement(mouseHover);
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void getTopButton()
	{
		driver.findElement(topButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
	
	public void getReloadButton()
	{
		driver.findElement(reloadButton);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}    
}
