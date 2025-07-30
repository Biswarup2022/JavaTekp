package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OlympicScenario {
	
	public static void main(String[] args) {
		
		String athleteName = "Keno MACHADO";
		
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
		driver.findElement(By.xpath("//p[contains(text(),'Light Heavy (75-81kg)')]")).click();
		driver.findElement(By.xpath("//span[text()='Go']")).click();
		
		String athletes = driver.findElement(By.xpath("//div[@data-cy='table-content']/div[@class='sc-4ffa8ad5-11 sc-62f3057c-0 dLpUAr ivOwjn']/descendant::h3[text()='"+athleteName+"']")).getText();
		String countryName = driver.findElement(By.xpath("//h3[text()='"+athleteName+"']/ancestor::div[@class='sc-4ffa8ad5-4 gKRjTb']/ancestor::div[@data-cy='single-athlete-result-row']/descendant::span[@class='sc-3431cf63-1 dhvwRN']")).getText();
		
		System.out.println("Athelete Name ==> "+athletes);
		System.out.println("Athelete Country ==> "+countryName);
		
		driver.close();
	}

}
