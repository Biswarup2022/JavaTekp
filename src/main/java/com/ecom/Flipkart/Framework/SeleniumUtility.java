package com.ecom.Flipkart.Framework;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {

	public void getImplycitlyWaitAndMaximize(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	public void getExplicitWait(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void getURLToFlipkart(WebDriver driver, String url) {
		
		driver.get(url);
	}
	
	public void getURLToAmazon(WebDriver driver, String url) {
		
		driver.get(url);
	}
	
	public void getSwitchToWindowByTitle(WebDriver driver) {
		
		String parentId = driver.getWindowHandle();
		Set<String> allIDs = driver.getWindowHandles();
		for(String newID : allIDs)
		{
			if(!newID.equals(parentId))
			{
				driver.switchTo().window(newID);
			}
		}
	}
	
	public void getScrollToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	public void waitForElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.pause(2000).perform();
	}
	
}
