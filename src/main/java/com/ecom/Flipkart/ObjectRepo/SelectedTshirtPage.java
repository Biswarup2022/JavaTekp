package com.ecom.Flipkart.ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecom.Flipkart.Framework.SeleniumUtility;

public class SelectedTshirtPage {

SeleniumUtility sLib = new SeleniumUtility();
	
	public SelectedTshirtPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@class='col col-6-12 ']")
	private WebElement addToCartBtn;

	@FindBy(xpath="//div[@class='cjMG1q']")
	private WebElement cartBtn;
		
	@FindBy(xpath="//button[text()='+']")
	private WebElement addTwoButton;

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}

	public WebElement getCartBtn() {
		return cartBtn;
	}
	
	public WebElement getAddTwoButton() {
		return addTwoButton;
	}

	public void addTshirtToCart(WebDriver driver) throws Throwable {
		
		Thread.sleep(2000);
		sLib.getScrollToElement(driver, getAddToCartBtn());
		getAddToCartBtn().click();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		getCartBtn().click();
		Thread.sleep(2000);
		getAddTwoButton().click();
		
		WebElement visibility = driver.findElement(By.xpath("//div[@class='eIDgeN']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(visibility));
		
		String expectedPrice = driver.findElement(By.xpath("//div[@class='x9LoV+']/span[@class='LAlF6k re6bBo']")).getText();
		System.out.println("Price:"+expectedPrice);
		String data = expectedPrice.replaceAll("[^0-9]", "");
		int expectPrice=Integer.parseInt(data)+4;
		System.out.println("Total Amount After Adding Platform Fee Rs4 ==> "+expectPrice);
		String price = driver.findElement(By.xpath("//div[@class='kQCHPX']/div/div[@class='uJ4ZKF']/div/div[@class='_1Y9Lgu']")).getText();
		String data2 = price.replaceAll("[^0-9]", "");
		int actualPrice=Integer.parseInt(data2);
		System.out.println("Actual Price From Cart ==> "+actualPrice);
		Assert.assertEquals(expectPrice, actualPrice);
		System.out.println("<==== Validation Successfull ====>");
	}
}
