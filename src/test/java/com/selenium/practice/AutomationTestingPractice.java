package com.selenium.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AutomationTestingPractice {
	@Test
	public void table() {

		String prod = "Wireless Mouse 20";

		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 2700);");

		for(int i=1; i<=4; i++) {
			List<WebElement> lst =driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr/td[.='"+prod+"']"));
			if(lst.size()>0) {
				driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td/input")).click();
				String price = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr/td[position()=3]")).getText();

				for(WebElement e : lst) {
					System.out.println(e.getText()+" : "+"Page Number-"+i);
					System.out.println(price);
				}
				break;
			}
			else {
				driver.findElement(By.xpath("//div[@class='table-container']/ul/li/a[.='"+(i+1)+"']")).click();
			}
		}
		driver.close();
	}
	
	
	@Test
	public void slider() {
		
		WebDriver driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement slider = driver.findElement(By.xpath("//h2[text()='Slider']"));
		Actions act = new Actions(driver);
		act.scrollToElement(slider).perform();
		
		WebElement left = driver.findElement(By.xpath("//span[@style='left: 15%;']"));
		WebElement right = driver.findElement(By.xpath("//span[@style='left: 60%;']"));
		
		for(int i=75; i>=0; i--) {
			
			left.sendKeys(Keys.ARROW_LEFT);
		}
		
		for(int i=300; i<=500; i++) {
			
			right.sendKeys(Keys.ARROW_RIGHT);
		}
		
		String price = driver.findElement(By.id("amount")).getAttribute("value");
		System.out.println("Expected Price ==> "+price);
		
		driver.close();
		
		//*[name()='svg']/*[name()='circle' and @fill='red']
		//*[name()='svg']/*[name()='rect' and @fill='green']
		//*[name()='svg']/*[name()='polygon' and @fill='blue']
	}
}

