package com.ecom.Flipkart.ObjectRepo;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IphoneProductPage {

	@FindBy(xpath = "//span[text()='Men']")
	private WebElement menMenu;
	
	@FindBy(xpath = "//a[text()='T-Shirts']")
	private WebElement tshirtsMenu;
	
	public IphoneProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getMenMenu() {
		return menMenu;
	}

	public WebElement getTshirtsMenu() {
		return tshirtsMenu;
	}
	
	public void getClickOnMenAndTshirts(WebDriver driver) {
		
		getMenMenu().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(tshirtsMenu));
		getTshirtsMenu().click();
	}
}
