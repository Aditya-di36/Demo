package com.actitime.utility;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
	//WebDriver Interface
	public String fetchPageTitle(WebDriver driver , String expectedTitle)
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle, "title validation failed");
		Reporter.log("title validation passed", true);
		return actualTitle;
	}
	
	//WebElement Interface
	public void removeText(WebElement element , WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		Assert.assertTrue(element.getDomAttribute("value").isBlank(), "text is not cleared");
		Reporter.log("text is cleared");
	}
	
	//Select Class
	public void selectOptionByText(WebElement element , String text , String selectedText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
		Assert.assertTrue(select.getFirstSelectedOption().getText().equals(selectedText), "selected text is wrong");
		Reporter.log("selected text is correct", true);
	}
	
	//Actions Class
	public void dragDropElement(WebDriver driver , WebElement source , WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}
	
	//JavascriptExecutor Interface
	public void highlightElement(WebDriver driver , WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background : pink')", element);
	}
}