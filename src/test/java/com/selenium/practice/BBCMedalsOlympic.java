package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BBCMedalsOlympic {
	
public static void main(String[] args) {
	
		String sports = "Archery";
		String gender = "Men's Individual";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.bbc.com/sport/olympics/paris-2024/medals");
		
		driver.findElement(By.linkText("Medal results")).click();
		
		WebElement filterDD = driver.findElement(By.id("discipline-selector"));
		Select se = new Select(filterDD);
		se.selectByVisibleText(sports);
		
		WebElement genderDD = driver.findElement(By.id("event-selector"));
		Select sel = new Select(genderDD);
		sel.selectByVisibleText(gender);
		
		List<WebElement> allCountries = driver.findElements(By.xpath("//div[contains(@class,'SecondaryName')]"));
		System.out.println("Winning Countries ==> ");
		for(WebElement country : allCountries) {
			System.out.println(country.getText());
		}
		
		driver.close();
	}
}
