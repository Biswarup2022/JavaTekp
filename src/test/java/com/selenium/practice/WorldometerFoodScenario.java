package com.selenium.practice;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WorldometerFoodScenario {

	public static void main(String[] args) {
		
		String expectedFoodTitle = "Food and Agriculture Statistics - Worldometer";
		String moreOptionDD = "Food & Agriculture";
		String countryName = "India";
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
		
		driver.findElement(By.xpath("//p[text()='More']")).click();
		driver.findElement(By.xpath("//ul[@class='text-sm']/descendant::a[text()='"+moreOptionDD+"']")).click();
		String actFoodTitle = driver.getTitle();
		
		Assert.assertEquals(actFoodTitle, expectedFoodTitle);
		driver.findElement(By.xpath("//div[@class='col-span-3']/descendant::a[text()='"+countryName+"']")).click();
		
		String nourishedNum = driver.findElement(By.xpath("//div[contains(text(),'How many are')]/../descendant::strong[@class='text-2xl']")).getText();
		System.out.println(nourishedNum);
		
		driver.findElement(By.xpath("//*[name()='rect' and @class='highcharts-plot-border' and @x='84' and @height='248']"));
		
	}
}
