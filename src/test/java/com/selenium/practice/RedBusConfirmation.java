package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBusConfirmation {

	@Test
	public void confirmation() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
		
		driver.findElement(By.xpath("//i[@class='icon___ceddca icon icon-date_range']")).click();
		
		List<WebElement> cal = driver.findElements(By.xpath("//div[@class='mainDatesWrap___bbffd1']/descendant::div[@class='dateWrap___861a4b']/div"));
		for(WebElement date : cal) {
			
			String p = date.getAttribute("data-datetype").toString();
			System.out.println(p);
		}
	}
}
