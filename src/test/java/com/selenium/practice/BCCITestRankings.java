package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BCCITestRankings {

	public static void main(String[] args) {
		
		String team = "South Africa";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.bcci.tv/international/men/rankings/test");
		
		String t = driver.findElement(By.xpath("//div[@class='t-rank']/descendant::h6[text()='"+team+"']")).getText();
		String rating = driver.findElement(By.xpath("//table[@class='table']//h6[text()='"+team+"']/ancestor::tr/td[last()]/p")).getText();
		
		System.out.println(team+" ==> "+rating);
		
		driver.close();
	}
}
