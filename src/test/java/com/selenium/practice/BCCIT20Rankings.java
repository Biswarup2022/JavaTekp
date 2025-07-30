package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BCCIT20Rankings {
	
public static void main(String[] args) {
		
		String team = "South Africa";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.bcci.tv/international/men/rankings/test");
		
		driver.findElement(By.xpath("//button[text()='T20I']")).click();
		WebElement ratingEle = driver.findElement(By.xpath("//table[@class='table']//h6[text()='"+team+"']/ancestor::tr/td[last()]/p"));
	     String rating = ratingEle.getText();
	     System.out.println(team + " ==> " + rating);
	     
	     driver.close();
	}

}
