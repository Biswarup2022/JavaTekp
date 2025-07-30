package com.ecom.Flipkart.ObjectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Flipkart.Framework.ExcelUtility;

public class AmazonHomePage {
	
	ExcelUtility eLib = new ExcelUtility();	

	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchTextField;

	public AmazonHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}
	
	public void searchMobile(String text) throws Throwable {
		
		getSearchTextField().sendKeys(text, Keys.ENTER);
	}
	
}
