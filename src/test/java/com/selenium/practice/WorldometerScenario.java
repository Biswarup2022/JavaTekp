package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorldometerScenario {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
		
		driver.findElement(By.linkText("Population by Country")).click();
		driver.findElement(By.linkText("view full table")).click();
		WebElement holySee = driver.findElement(By.linkText("Holy See"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(holySee).perform();
		
		driver.close();
	}	
}
