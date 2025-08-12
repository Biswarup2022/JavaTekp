package com.ecom.Flipkart.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.Flipkart.Framework.SeleniumUtility;

public class MMT1HomePage {
	
	SeleniumUtility sLib = new SeleniumUtility();

	@FindBy(className = "commonModal__close")
	private WebElement crossIcon;
	
	@FindBy(id = "fromCity")
	private WebElement fromCity;

	@FindBy(id = "react-autowhatever-1-section-0-item-0")
	private WebElement fromCitySelection;
	
	@FindBy(id = "toCity")
	private WebElement toCity;

	@FindBy(id = "react-autowhatever-1-section-0-item-0")
	private WebElement toCitySelection;
	
	@FindBy(xpath = "//div[@aria-label='Thu Sep 18 2025']")
	private WebElement dateSelection;
	
	@FindBy(xpath = "//span[@class='appendRight10']")
	private WebElement travellerSelection;
	
	@FindBy(xpath = "//div[@class='fltTravellers gbTravellers']//li[@data-cy='adults-2']")
	private WebElement adultsSelection;
	
	@FindBy(xpath = "//button[text()='APPLY']")
	private WebElement applyButton;
	
	@FindBy(xpath = "//a[text()='Search']")
	private WebElement searchButton;
	
	public MMT1HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getCrossIcon() {
		return crossIcon;
	}

	public WebElement getFromCity() {
		return fromCity;
	}

	public WebElement getFromCitySelection() {
		return fromCitySelection;
	}

	public WebElement getToCity() {
		return toCity;
	}

	public WebElement getToCitySelection() {
		return toCitySelection;
	}

	public WebElement getDateSelection() {
		return dateSelection;
	}

	public WebElement getTravellerSelection() {
		return travellerSelection;
	}

	public WebElement getAdultsSelection() {
		return adultsSelection;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	public void searchFlightsTest() throws Throwable {
		
		getCrossIcon().click();
		Thread.sleep(2000);
		getFromCity().sendKeys("Bengaluru");
		Thread.sleep(2000);
		getFromCitySelection().click();
		Thread.sleep(2000);
		getToCity().sendKeys("Kolkata");
		Thread.sleep(2000);
		getToCitySelection().click();
		Thread.sleep(2000);
		getDateSelection().click();
		getTravellerSelection().click();
		getAdultsSelection().click();
		getApplyButton().click();
		getSearchButton().click();
	}
}
