package com.ecom.Flipkart.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Flipkart.Framework.SeleniumUtility;

public class TshirtsPage {

	SeleniumUtility sLib = new SeleniumUtility();
	
	public TshirtsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[text()='Brand']")
	private WebElement brandDropDown;

	@FindBy(xpath="//div[text()='PUMA']")
	private WebElement pumaCheckBox;

	@FindBy(xpath = "//div//a[text()='2']")
	private WebElement secondPageBtn;

	@FindBy(xpath= "//div[@class='_1sdMkc LFEi7Z']")
	private WebElement tShirt;
	
	public WebElement getBrandDropDown() {
		return brandDropDown;
	}
	
	public WebElement getPumaCheckBox() {
		return pumaCheckBox;
	}
	
	public WebElement getSecondPageBtn() {
		return secondPageBtn;
	}
	
	public WebElement getTShirt() {
		return tShirt;
	}

	public void selectTShirt(WebDriver driver) throws Throwable {
		
		sLib.getScrollToElement(driver, getBrandDropDown());
		getBrandDropDown().click();
		Thread.sleep(2000);
		getPumaCheckBox().click();
		sLib.getScrollToElement(driver, getSecondPageBtn());
		getSecondPageBtn().click();
		Thread.sleep(2000);
		sLib.getScrollToElement(driver, getTShirt());
		getTShirt().click();
		
	}
	
}
