package com.ecom.Flipkart.ObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	@FindBy(className = "Pke_EE")
	private WebElement searchTextField;
	
	public FlipkartHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public void searchIphone(String text) {
		
		getSearchTextField().sendKeys(text, Keys.ENTER);
	}
	
}
