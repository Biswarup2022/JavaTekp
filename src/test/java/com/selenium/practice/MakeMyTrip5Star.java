package com.selenium.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MakeMyTrip5Star {
	
public static void main(String[] args) {
		
		String place = "Goa";
		String checkInDate = "Tue Jul 22 2025";
		String checkOutDate = "Sat Jul 26 2025";
		int roomNos = 1;
		int guestNos = 2;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//li[@class='menu_Hotels']")).click();
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(place);
		driver.findElement(By.xpath("//li[@role='option' and @id='react-autowhatever-1-section-0-item-1']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Week']/div[@aria-label='"+checkInDate+"']")).click();
		driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Week']/div[@aria-label='"+checkOutDate+"']")).click();
		driver.findElement(By.xpath("//span[@data-testid='room_count']")).click();
		driver.findElement(By.xpath("//ul[@class='gstSlct__list']/descendant::li[text()='"+roomNos+"']")).click();
		driver.findElement(By.xpath("//span[@data-testid='adult_count']")).click();
		driver.findElement(By.xpath("//ul[@class='gstSlct__list']/descendant::li[text()='"+guestNos+"']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		
	}

}
