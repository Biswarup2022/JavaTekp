package com.selenium.practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlipkartCartProduct {

	@Test
	public void addToCartProductTest() throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone",Keys.ENTER);
		driver.findElement(By.xpath("//span[text()='Men']")).click();
		driver.findElement(By.xpath("//a[text()='T-Shirts']")).click();
		
		Actions act=new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//div[@class='b5p4CI']"));
		act.scrollToElement(move).perform();
		driver.findElement(By.xpath("//a[text()='2']")).click();
		
		WebElement customerRating = driver.findElement(By.xpath("//div[text()='Customer Ratings']"));
		act.scrollToElement(customerRating).perform();
		
		driver.findElement(By.xpath("//div[text()='Brand']")).click();
		driver.findElement(By.xpath("//div[text()='PUMA']")).click();
		
		WebElement scroll = driver.findElement(By.xpath("//div[text()='Lowest price since launch']"));
		act.scrollToElement(scroll).perform();
		
		driver.findElement(By.xpath("//div[@class='_1sdMkc LFEi7Z']")).click();

		String parentWin = driver.getWindowHandle();
		Set<String> allWin = driver.getWindowHandles();
		for(String newId:allWin)
		{
			if(newId!=(parentWin))
			{
				driver.switchTo().window(newId);
			}
		}
		Thread.sleep(1000);
		WebElement scr = driver.findElement(By.xpath("//div[text()='You might be interested in']"));
		act.scrollToElement(scr).perform();
		driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2']")).click();
		driver.switchTo().window(parentWin);
	
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='+']")).click();
		
		WebElement visibility = driver.findElement(By.xpath("//div[@class='eIDgeN']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibility));
		
		String expectedPrice = driver.findElement(By.xpath("//div[@class='x9LoV+']/span[@class='LAlF6k re6bBo']")).getText();
		System.out.println("Price:"+expectedPrice);
		String data = expectedPrice.replaceAll("[^0-9]", "");
		int expectPrice=Integer.parseInt(data)+4;
		System.out.println("Total Amount After Adding Platform Fee Rs4 ==> "+expectPrice);
		String price = driver.findElement(By.xpath("//div[@class='kQCHPX']/div/div[@class='uJ4ZKF']/div/div[@class='_1Y9Lgu']")).getText();
		String data2 = price.replaceAll("[^0-9]", "");
		int actualPrice=Integer.parseInt(data2);
		System.out.println("Actual Price From Cart ==> "+actualPrice);
		Assert.assertEquals(expectPrice, actualPrice);
		System.out.println("<==== Validation Successfull ====>");
		driver.quit();	
		
	}
	
	@Test
	public void nyakaaOTPTest() throws InterruptedException {
		
		String expText = "Something went Wrong";
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.nykaa.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@label='Mobile Number']")).sendKeys("9876543210");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Send OTP']")).click();
		Thread.sleep(2000);
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='css-otw3fu']"));
		
		for(int i=0; i<checkboxes.size(); i++) {
			
			Keys k = Keys.valueOf("NUMPAD"+(i+1));
			checkboxes.get(i).sendKeys(k);
		}
		
		String actText = driver.findElement(By.xpath("//div[@class='css-vq7uqt']")).getText();
		System.out.println(actText);
		
		Assert.assertEquals(expText, actText);
		System.out.println("<==== Validation Successfull ====>");
		
		driver.close();
	}
}
