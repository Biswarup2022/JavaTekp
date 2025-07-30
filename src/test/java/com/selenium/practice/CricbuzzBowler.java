package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzBowler {

public static void main(String[] args) throws Throwable {
		
		String playerName = "Jasprit Bumrah";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com");
		
		driver.findElement(By.xpath("//a[text()='Rankings']")).click();
		driver.findElement(By.linkText("Bowling")).click();
		
		String players = driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/descendant::a[text()='"+playerName+"']")).getText();
		String countryName = driver.findElement(By.xpath("//a[text()='"+playerName+"']/parent::div/div[@class='cb-font-12 text-gray']")).getText();
		String rating = driver.findElement(By.xpath("//a[text()='"+playerName+"']/ancestor::div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/descendant::div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']")).getText();
		
		System.out.println("Given Player Name ==> "+players);
		System.out.println("Given Player Country ==> "+countryName);
		System.out.println("Given Player Rating ==> "+rating);
		
		driver.close();
	}
}
