package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OlympicBejingScenario {

public static void main(String[] args) {
		
		String athleteName = "Keno MACHADO";
		String eventName = "Light Heavy (75-81kg)";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.olympics.com/en/olympic-games/tokyo-2020");
		
		driver.findElement(By.xpath("//button[text()='No, manage settings']")).click();
		driver.findElement(By.xpath("//button[text()='Reject All']")).click();
		
		driver.findElement(By.linkText("Results")).click();
		
		WebElement boxing = driver.findElement(By.xpath("//p[text()='Boxing']"));
		Actions act = new Actions(driver);
		act.scrollToElement(boxing).perform();
		act.click(boxing).perform();
		
		driver.findElement(By.xpath("//span[text()='Event']")).click();
		driver.findElement(By.xpath("//p[contains(text(),'"+eventName+"')]")).click();
		
		driver.findElement(By.xpath("//div[@class='sc-d0fd8f2b-3 oxuPj']/span[text()='Tokyo 2020']")).click();

		driver.findElement(By.xpath("//p[text()='Beijing 2022']")).click();
		driver.findElement(By.xpath("//span[text()='Discipline']")).click();
		
		String game = "Alpine Skiing";

		driver.findElement(By.xpath("//p[text()='"+game+"']")).click();
		
		driver.findElement(By.xpath("//span[text()='Event']")).click();

		String partialtext = "s Super-G";
		
		driver.findElement(By.xpath("//p[contains(text(),'"+partialtext+"')]")).click();

		driver.findElement(By.xpath("//span[text()='Go']")).click();
		
		String name = "Trevor PHILP";
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1500);");
		String country = driver.findElement(By.xpath("//h3[text()='"+name+"']/ancestor::div[@class='sc-4ffa8ad5-4 gKRjTb']/preceding-sibling::div[@class='sc-4ffa8ad5-1 eimYXX']/div/span")).getText();
		System.out.println("Player ==> " + name+" Country ==> " + country);
		
		driver.quit();


	}
}
