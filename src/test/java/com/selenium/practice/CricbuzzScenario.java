package com.selenium.practice;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricbuzzScenario {

	public static void main(String[] args) {
		
		String playerName = "Shubman Gill";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com");
		
		driver.findElement(By.xpath("//a[text()='Rankings']")).click();
		driver.findElement(By.xpath("//a[text()='ODI']")).click();
		
		String players = driver.findElement(By.xpath("//div[@class='cb-col cb-col-100 cb-padding-left0']/div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/div[@class='cb-col cb-col-50 cb-lst-itm-sm text-left']/div/following-sibling::div/a[text()='"+playerName+"']")).getText();
		String countryName = driver.findElement(By.xpath("//a[text()='"+playerName+"']/../div")).getText();
		String rating = driver.findElement(By.xpath("//a[text()='"+playerName+"']/ancestor::div[@class='cb-col cb-col-100 cb-font-14 cb-lst-itm text-center']/div[@class='cb-col cb-col-17 cb-rank-tbl pull-right']")).getText();
		
		System.out.println("Name of the Batsman ==> "+players);
		System.out.println("Country of the Batsman ==> "+countryName);
		System.out.println("Rating of the Batsman ==> "+rating);
		
		driver.close();
	}
}
