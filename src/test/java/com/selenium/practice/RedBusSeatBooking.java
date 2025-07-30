package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedBusSeatBooking {

	public static void main(String[] args) {
		
		String month = "July";
		int date = 12;
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
//		WebElement monthC = driver.findElement(By.xpath("//div[@class='mainDatesWrap___bbffd1']/descendant::p[text()='"+month+"']"));
//		WebElement dateC = driver.findElement(By.xpath("//div[@class='mainDatesWrap___bbffd1']/descendant::span[text()='"+date+"']"));
		
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//div[text()='Bangalore']")).click();
		
		driver.findElement(By.xpath("//div[text()='Hyderabad']")).click();
		
		driver.findElement(By.xpath("//button[text()='Search buses']")).click();
		
		Actions act = new Actions(driver);
	
		WebElement vikramTravels = driver.findElement(By.xpath("//div[text()='Vikram Travels']"));
		act.scrollToElement(vikramTravels);
		driver.findElement(By.xpath("//div[text()='Vikram Travels']/ancestor::div[@class='timeFareBoWrap___427775']/following-sibling::button")).click();
		
		List<WebElement> seats = driver.findElements(By.xpath("//span[@class='sleeper__ind-seat-styles-module-scss-Z8-su ']"));
		
		System.out.println("Total SEAT Capacity ==> "+seats.size());
				
			for(WebElement seat : seats) {
			String value = seat.getText();
			
			String seatNumber = seat.getDomAttribute("id").toString();
			
			if(!value.equals("Sold") && !value.equals(" ")) {
				
				act.scrollByAmount(0, 1500);
				System.out.println("Available Seat Number ==> "+seatNumber);
				System.out.println("Fair of Seat ==> "+value);
			}
			
		}
			driver.close();
			
	}
}
